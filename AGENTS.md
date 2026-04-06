## 프로젝트 개요
이 프로젝트는 HWPX(Hangeul Word Processor XML) 기반 보고서 자동화를 위한 Python 라이브러리 및 CLI 도구이다.

목표:
- HWPX 파일을 읽고 수정하고 다시 생성할 수 있어야 한다
- 템플릿 기반으로 데이터를 주입하여 보고서를 자동 생성한다
- pandas DataFrame을 HWPX 표로 변환할 수 있어야 한다
- 결과물은 한글(HWP)에서 정상적으로 열려야 한다

## 기술 스택
- Python 3.11+
- pathlib (파일 처리)
- zipfile (HWPX 압축 처리)
- lxml 또는 ElementTree (XML 처리)
- pandas (데이터 처리)
- pytest (테스트)
