# hwpx-owpml-model 분석

## 한 줄 요약

`hwpx-owpml-model`은 HWPX를 구성하는 OWPML XML 파트를 C++ 객체 모델로 읽고, 다시 저장할 수 있게 만든 Windows/Visual Studio 기반 라이브러리이다.

이 저장소는 단순한 "파서"가 아니라 다음 4가지를 함께 제공한다.

1. HWPX 패키지(zip) 열기/쓰기
2. XML 파트별 SAX 파싱
3. OWPML 스키마를 반영한 방대한 객체 모델
4. 문서 단위 API와 예제 프로그램

## 디렉터리별 역할

### `hwpx-owpml-model/OWPML`

핵심 엔진이다.

- `Document.h/.cpp`
  HWPX 컨테이너를 열고, zip entry를 읽고 쓰고, XML 파트를 파싱하는 중심 클래스다.
- `Base/`
  공통 객체 계층, SAX reader, serializer, attribute 처리 등 모델 프레임워크가 들어 있다.
- `Class/`
  OWPML 각 XML 요소를 표현하는 concrete class 모음이다.
- `Zip/`
  zip/unzip 및 암호화 관련 구현이 있다.
- `Expat/`
  XML 파싱에 사용하는 Expat 연동 코드가 있다.
- `Hwp/`
  메타태그 관련 최소 헤더가 있다.

### `hwpx-owpml-model/OWPMLApi`

엔진을 직접 다루지 않고 문서 단위로 쓰기 위한 얇은 API 계층이다.

- `COwpmlDocumnet`
  문서 열기/저장과 주요 루트 모델 접근을 제공한다.
- `COwpmlSerialize`
  실제 열기/저장 orchestration을 담당한다.
- `COwpmlSerializeModel`
  메타태그 객체 보관용 보조 모델이다.

### `hwpx-owpml-model/OWPMLTest`

샘플 프로그램이다.

- `OWPMLTest.cpp`
  `.hwpx`를 열고 첫 번째 섹션만 순회해 텍스트를 추출하는 예제가 들어 있다.

### `hwpx-owpml-model/OWPMLUtil`

암호화, SHA, 경로 처리, 문자열/플랫폼 보조 코드가 있다.

## 이 모델이 실제로 하는 일

코드 기준으로 보면 이 프로젝트의 핵심 책임은 "HWPX 패키지 전체를 객체 그래프로 매핑하는 것"이다.

### 1. HWPX 패키지 관리

`OWPML/Document.h`의 `CDocument`는 다음 역할을 가진다.

- 파일 포맷 감지
- zip 기반 패키지 열기
- 개별 파트 읽기/쓰기
- manifest, spine, metadata 관리
- 암호화 정보와 서명 정보 관리

즉 HWPX를 "압축된 여러 XML/리소스 파일 묶음"으로 보고, 그 묶음을 열고 조작하는 책임을 가진다.

### 2. XML 파트를 객체 모델로 역직렬화

`OWPML/Base/Object.h`의 `CObject` / `CExtObject`가 공통 기반이다.

- 모든 OWPML 요소는 `CObject`를 상속한다.
- 자식 요소를 가지는 노드는 `CExtObject`를 사용한다.
- 각 concrete class는 자신의 자식 element map과 attribute 읽기/쓰기 로직을 가진다.

결국 XML DOM을 그대로 쓰는 대신, 태그마다 대응되는 C++ 클래스를 두는 방식이다.

### 3. OWPML 스키마를 코드로 펼쳐 둠

`OWPML/Class/`는 사실상 OWPML 스키마의 코드화다.

- `Core/`: 색상, 이미지, 좌표, fill/margin 같은 공통 타입
- `Head/`: 폰트, 스타일, numbering, borderFill, 문서 호환성 등 헤더/스타일 영역
- `Etc/`: version, package, manifest, section, history, application setting 등 문서 구조 요소
- `Para/`: 문단, 런, 표, 도형, 컨트롤, 주석, 필드 등 본문 요소
- `RDF/`: RDF 관련 요소

파일 수만 봐도 의도가 분명하다.

- `Core`: 20개 파일
- `Etc`: 72개 파일
- `Head`: 214개 파일
- `Para`: 268개 파일

즉 이 저장소의 본질은 "HWPX 문서 전체를 거의 스키마 수준으로 표현하는 모델 정의"다.

### 4. 문서 단위 API 제공

`OWPMLApi/OWPMLDocument.h`의 `COwpmlDocumnet`는 다음 루트 객체 접근자를 제공한다.

- `GetVersion()`
- `GetApplicationSetting()`
- `GetPackage()`
- `GetHead()`
- `GetHistories()`
- `GetSections()`

이 구조를 보면 사용자는 개별 XML 파일을 직접 열기보다, 문서 전체를 연 뒤 루트 모델을 꺼내 탐색하는 사용 방식을 의도한 것으로 보인다.

## 읽기/쓰기 흐름

코드를 기준으로 정리하면 대략 이런 흐름이다.

1. `COwpmlDocumnet::OpenDocument(path)` 호출
2. 내부에서 `COwpmlSerialize::Open(path)` 호출
3. `COwpmlSerialize`가 `CDocument`를 사용해 HWPX 패키지를 연다
4. `content.hpf`, head, section, history, preview, bindata 등 개별 파트를 읽는다
5. 각 XML 파트는 대응하는 `CObject` 계열 클래스로 파싱된다
6. 호출자는 `GetHead()`, `GetSections()` 같은 루트 접근자로 모델을 탐색한다
7. 저장 시에는 반대로 각 모델을 XML로 serialize해서 zip 패키지로 다시 쓴다

즉 "zip package <-> XML part <-> C++ object model"을 왕복하는 구조다.

## 테스트 예제가 보여주는 사용 방식

`OWPMLTest/OWPMLTest.cpp`는 라이브러리의 의도를 잘 보여준다.

- `.hwpx` 파일을 연다
- `GetSections()`로 섹션 목록을 얻는다
- 첫 번째 섹션만 재귀 순회한다
- `ID_PARA_T`, `ID_PARA_Char`, `ID_PARA_LineSeg` 같은 para 계층 객체를 해석해 텍스트를 만든다

중요한 점은, 텍스트 추출도 XML 문자열 처리로 하지 않고 OWPML 객체 모델을 따라 내려가며 수행한다는 것이다.

즉 이 저장소의 설계 방향은 "문서 구조를 모델 객체로 해석한 뒤, 그 객체를 기반으로 처리한다"는 쪽이다.

## 이 저장소를 보면 알 수 있는 설계 특징

### 장점

- HWPX를 파트 단위가 아니라 문서 모델 단위로 다룰 수 있다.
- 스키마 대응이 세밀해서 보존력이 높다.
- 읽기뿐 아니라 저장까지 염두에 둔 구조다.
- manifest, spine, history, preview, bindata까지 문서 전체를 다루려는 범위가 넓다.

### 한계

- Visual Studio 프로젝트 중심이라 현재 Python 프로젝트에 바로 재사용하기는 어렵다.
- 객체 수가 매우 많아서 러닝커브가 높다.
- 공개 예제는 첫 번째 섹션 텍스트 추출 정도로 제한적이다.
- `COwpmlDocumnet::CreateDocument()`는 `"Default Document Path"` 같은 placeholder가 남아 있어 생성 API가 완성형은 아니다.
- 네이밍 품질이 고르지 않다. 예: `COwpmlDocumnet`, `PushMataTag`.

## 이 프로젝트에 주는 시사점

현재 Python 기반 `hwpx` 프로젝트 관점에서 보면, `hwpx-owpml-model`은 바로 가져다 쓰는 라이브러리라기보다 참조 구현에 가깝다.

특히 참고할 만한 부분은 다음이다.

1. HWPX를 "zip 안의 여러 파트"로 취급하는 패키지 계층
2. `head`, `section`, `history`, `bindata` 같은 루트 파트 구분
3. 본문을 paragraph/run/control/tree 구조로 탐색하는 방식
4. manifest/spine/metadata를 별도 모델로 유지하는 방식
5. 단순 텍스트 추출이 아니라 재저장 가능성을 고려한 모델 설계

반대로 Python 구현에서는 이 C++ 프로젝트처럼 모든 요소를 1:1 클래스로 옮기기보다, 우선순위가 높은 파트부터 축약 모델로 설계하는 편이 현실적이다.

## 결론

`hwpx-owpml-model`은 HWPX용 "객체 모델 + 패키지 처리 + 직렬화 엔진"이다.

정확히 말하면:

- `OWPML`은 저수준 문서 엔진
- `OWPMLApi`는 문서 단위 접근 API
- `OWPMLTest`는 모델 탐색 예제
- `OWPMLUtil`은 암호화/문자열/경로 유틸리티

따라서 이 디렉터리는 단순 샘플 코드 모음이 아니라, HWPX/OWPML 문서를 읽고 수정하고 다시 쓰기 위한 참조용 C++ 모델 구현체로 이해하는 것이 맞다.
