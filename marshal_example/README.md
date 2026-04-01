# marshal_example

This directory contains a JAXB example for reading a `.hpf` XML file into an `org...` Java package.

## Goal

Convert:

`content.hpf` -> inferred `content.xsd` -> generated JAXB classes under an `org...` package

Then use those generated classes with JAXB to unmarshal the `.hpf` file.

## Important limitation

JAXB does not generate Java classes from `.hpf` directly. The workflow is:

1. infer or obtain an XSD
2. run `xjc` on that XSD
3. use `JAXBContext` and `Unmarshaller` on the `.hpf`

Because this repo only has `content.hpf`, the XSD step uses `trang` to infer a schema from the sample XML.

## Files

- `App.kt`
  Simple Kotlin program that unmarshals and marshals the OPF package
- `content.hpf`
  Sample input document
- `generate_org_package.sh`
  Script that runs `trang` and `xjc`
- `org/idpf/_2007/opf`
  Existing generated JAXB classes for the OPF namespace

## Requirements

- Java
- `trang.jar`
- Either:
  - a system `xjc` command, or
  - `jaxb-xjc.jar`

## Generate an org package from .hpf

From this directory:

```bash
chmod +x generate_org_package.sh
./generate_org_package.sh content.hpf /path/to/trang.jar org.idpf._2007.opf /path/to/jaxb-xjc.jar
```

If you already have `xjc` installed, omit the last argument:

```bash
./generate_org_package.sh content.hpf /path/to/trang.jar org.idpf._2007.opf
```

Output:

- inferred schema: `schema-gen/content.xsd`
- generated Java sources: `src-gen/org/idpf/_2007/opf/...`

## Read the .hpf with JAXB

Once the package has been generated and compiled, JAXB usage looks like this:

```kotlin
import java.io.File
import javax.xml.bind.JAXBContext
import org.idpf._2007.opf.Package

fun main() {
    val context = JAXBContext.newInstance(Package::class.java)
    val unmarshaller = context.createUnmarshaller()
    val pkg = unmarshaller.unmarshal(File("content.hpf")) as Package

    println(pkg.metadata.language)
    println(pkg.manifest.item.size)
    println(pkg.spine.itemref.size)
}
```

## Compile the existing example

The current `App.kt` is intended to compile like this:

```bash
kotlinc App.kt -include-runtime -d app.jar -cp .
java -cp app.jar:. AppKt content.hpf
```

But `App.kt` currently contains an unused `prettyPrintXml()` function with missing imports, so it should be cleaned up before relying on that build command.

## Practical note

The sample `.hpf` document contains many XML namespaces. The existing `org.idpf._2007.opf` package only models the OPF namespace. If you need the full `.hpf` structure as Java classes, the inferred or real schema must include those other namespaces as well.
