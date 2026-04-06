# DVC Subdirectory Investigation

## Summary

The `dvc/` directory is not related to Data Version Control. It is a separate C++ project named `HWPX Document Validation Checker` that validates whether an HWPX document conforms to a predefined formatting/specification checklist.

Within this repository, `dvc/` appears to be vendored as a nested Git repository rather than integrated into the Python codebase. It has its own `.git` directory, Visual Studio solution, Windows example program, and dependency setup instructions.

## What It Does

At a high level, DVC performs this pipeline:

1. Read CLI arguments or DLL API inputs.
2. Interpret the first non-option path as a validation spec JSON file and the second non-option path as the target HWPX file.
3. Open the HWPX document through Hancom's OWPML model.
4. Load the checklist JSON that describes allowed document properties.
5. Run a sequence of checks against document structures such as character styles, paragraph styles, tables, special characters, bullets, numbering, styles, hyperlinks, and macros.
6. Collect mismatches and emit them as JSON to console or file.

The intended use is described in [dvc/README.md](/home/kjhwan/Work/hwpx/dvc/README.md#L4), [dvc/README.md](/home/kjhwan/Work/hwpx/dvc/README.md#L52), and [dvc/README.md](/home/kjhwan/Work/hwpx/dvc/README.md#L84).

## Why It Exists

The project is designed for document compliance checking, not document generation or editing. The README says it is for determining whether an HWPX document matches an approved form or template for a given organization or workflow. In other words, this is a policy or QA tool for HWPX documents.

That makes `dvc/` conceptually adjacent to this repository's domain, but it solves a different problem:

- This repository's main goal is HWPX manipulation and report automation in Python.
- `dvc/` is a Windows-oriented C++ validator that checks whether a finished document follows allowed formatting rules.

## Main Execution Flow

### 1. Public entrypoint

The exported DLL API exposes `createDVC()` and `deleteDVC()` in [dvc/export/export.h](/home/kjhwan/Work/hwpx/dvc/export/export.h#L30). The example Windows app shows the expected usage:

1. Create the DVC object.
2. Pass CLI arguments into `setCommand`.
3. Run `doValidationCheck`.
4. Call `output`.
5. Destroy the object.

See [dvc/Examples/windows/ExampleWindows/ExampleWindows.cpp](/home/kjhwan/Work/hwpx/dvc/Examples/windows/ExampleWindows/ExampleWindows.cpp#L26).

### 2. Command parsing

`CommandParser` is responsible for default options and interpreting arguments. It:

- defaults to JSON output, console output, and "check all" mode
- treats the first non-option path as the checklist JSON
- treats the second non-option path as the target HWPX file
- supports flags such as `-j`, `-c`, `-s`, `-a`, `-t`, `-i`, `-o`, `-k`

This behavior is implemented in [dvc/CommandParser.cpp](/home/kjhwan/Work/hwpx/dvc/CommandParser.cpp#L45) and the documented options are listed in [dvc/README.md](/home/kjhwan/Work/hwpx/dvc/README.md#L91).

One notable detail: XML output is documented, but `-x` currently triggers a "not yet" error rather than a real XML serializer, so JSON is the only implemented output format right now. That is visible in [dvc/CommandParser.cpp](/home/kjhwan/Work/hwpx/dvc/CommandParser.cpp#L216).

### 3. Validation orchestration

`DVCModule::doValidationCheck()` is the top-level coordinator. It:

- resolves absolute paths for the checklist JSON and HWPX file
- constructs a `Checker`
- initializes it
- runs checks in a fixed order
- optionally stops on the first failed category in simple mode
- records errors for later output

The sequence is in [dvc/Source/DVCModule.cpp](/home/kjhwan/Work/hwpx/dvc/Source/DVCModule.cpp#L68).

The implemented validation categories are:

- `CheckCharShape`
- `CheckParaShape`
- `CheckTable`
- `CheckSpacialCharacter`
- `CheckBullet`
- `CheckParaNumBullet`
- `CheckStyle`
- `CheckHyperlink`
- `CheckMacro`

### 4. Checklist loading and document reading

`Checker::Initialize()` wires together the two required inputs:

- a `CheckList` object parsed from the JSON checklist file
- an `OWPMLReader` opened on the HWPX document

It also extracts `RunTypeInfo` records from the document so errors can later be mapped back to page, line, text, and table coordinates. See [dvc/Checker.cpp](/home/kjhwan/Work/hwpx/dvc/Checker.cpp#L61).

The HWPX parsing side is delegated to Hancom's OWPML model. `OWPMLReader` opens the document with `OWPML::COwpmlDocumnet::OpenDocument(...)` and lazily exposes readers for character shapes, paragraph shapes, tables, border fills, outline shapes, and bullets. See [dvc/Source/OWPMLReader.cpp](/home/kjhwan/Work/hwpx/dvc/Source/OWPMLReader.cpp#L28) and [dvc/Source/OWPMLReader.cpp](/home/kjhwan/Work/hwpx/dvc/Source/OWPMLReader.cpp#L80).

### 5. Error collection strategy

Each validation pass compares document structures against checklist rules and stores mismatches as internal error records. The checker then matches those errors back onto the document's run-level location information, so output records can include:

- page number
- line number
- text
- char/paragraph style references
- table coordinates when relevant

This pattern is visible in the character, paragraph, and table check implementations in [dvc/Checker.cpp](/home/kjhwan/Work/hwpx/dvc/Checker.cpp#L87), [dvc/Checker.cpp](/home/kjhwan/Work/hwpx/dvc/Checker.cpp#L135), and [dvc/Checker.cpp](/home/kjhwan/Work/hwpx/dvc/Checker.cpp#L183).

### 6. Output generation

Despite option names mentioning multiple formats, the active implementation creates JSON output objects and serializes them either to a file or stdout. `DVCOutputJson` builds a JSON array of error objects containing IDs, text, page/line numbers, error codes, and optionally table/style/shape/hyperlink-related fields depending on the selected output mode.

See [dvc/Source/DVCOutputJson.cpp](/home/kjhwan/Work/hwpx/dvc/Source/DVCOutputJson.cpp#L63) and [dvc/Source/DVCOutputJson.cpp](/home/kjhwan/Work/hwpx/dvc/Source/DVCOutputJson.cpp#L102).

## Inputs and Outputs

### Inputs

The tool expects two positional file inputs:

1. A checklist JSON file defining allowed document properties.
2. A target `.hwpx` document to validate.

The README points to `sample/jsonFullSpec.json` as the master example schema and explains that users can define only the subset they care about. See [dvc/README.md](/home/kjhwan/Work/hwpx/dvc/README.md#L84).

The schema constants in [dvc/Source/JsonModel.h](/home/kjhwan/Work/hwpx/dvc/Source/JsonModel.h#L21) show the checklist is extensive and property-oriented. It includes sections for character shape, paragraph shape, table properties, and many fine-grained sub-properties.

### Outputs

The output is a JSON array of validation errors. Each entry may include:

- `charIDRef`
- `paraPrIDRef`
- `text`
- `pageNo`
- `lineNo`
- `errorCode`
- table metadata such as `tableID`, `tableRow`, `tableCol`

An example output payload is shown in [dvc/README.md](/home/kjhwan/Work/hwpx/dvc/README.md#L117).

## Important Structural Observations

### It is Windows-first

The build instructions are centered on Visual Studio 2017 and a `.sln` file, and the included demo app is a Windows project. See [dvc/README.md](/home/kjhwan/Work/hwpx/dvc/README.md#L13), [dvc/README.md](/home/kjhwan/Work/hwpx/dvc/README.md#L44), and [dvc/DVCModel.sln](/home/kjhwan/Work/hwpx/dvc/DVCModel.sln).

There are some Linux conditionals in the code, but the documented and example workflow is clearly Windows-oriented.

### It depends on external C++ libraries

The README requires:

- Hancom `hwpx-owpml-model`
- `jsoncpp`

Those are described in [dvc/README.md](/home/kjhwan/Work/hwpx/dvc/README.md#L20). In this workspace, there is also a sibling `hwpx-owpml-model/` directory, which fits that dependency story.

### It is a separate nested repository

`dvc/` contains its own `.git` directory and appears as an untracked directory from the parent repository's point of view. That strongly suggests it was copied or vendored into this workspace rather than developed as part of the parent Python package.

### It is a validator, not a converter

Nothing in the inspected flow writes or edits HWPX files. The project opens a document, reads structural/style information, compares it against JSON rules, and reports violations. Its purpose is inspection and compliance reporting.

## Practical Interpretation For This Repository

If you are deciding whether `dvc/` is part of the core Python library here, the answer is effectively no.

It is better understood as:

- a reference implementation of HWPX validation logic
- an example of how to inspect HWPX internals through the OWPML C++ model
- a potentially reusable source of validation rules or ideas if similar functionality is later needed in Python

It does not currently appear wired into the Python package, tests, or CLI in the root project.

## Gaps and Limitations

- The documented XML output is not actually implemented; `-x` is rejected as not yet supported.
- Several API methods in `DVCModule` are stubs with empty bodies, including `setOption`, `setJsonFilepath`, and `setTargetFilepath`, so the CLI-driven path is the real implemented interface today. See [dvc/Source/DVCModule.cpp](/home/kjhwan/Work/hwpx/dvc/Source/DVCModule.cpp#L53).
- The project is not integrated with the Python tooling in this repository.
- The README describes more validation surface area than is necessarily complete; it explicitly says more HWPX features may be added later. See [dvc/README.md](/home/kjhwan/Work/hwpx/dvc/README.md#L8).

## Bottom Line

`dvc/` is a standalone C++ HWPX document compliance checker. It consumes a JSON rule specification plus a target HWPX file, reads the document through Hancom's OWPML model, validates formatting and structural properties, and emits JSON error reports. In this repository, it is best treated as an embedded reference project rather than part of the main Python implementation.
