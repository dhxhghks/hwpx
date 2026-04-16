# DVC Build Attempt Report

Date: 2026-04-16

## Goal

Build the `dvc/` project by following [dvc/README.md](/home/kjhwan/Work/hwpx/dvc/README.md).

Expected outputs:

- `DVCModel.dll`
- `DVCModel.lib`

## Environment Used

- Workspace: `/home/kjhwan/Work/hwpx`
- OS: `Linux user 6.6.87.2-microsoft-standard-WSL2 x86_64`
- Shell: `bash`
- Current date: `2026-04-16`

## What Was Checked

1. Confirmed the build instructions in `dvc/README.md`.
2. Confirmed the project type from `dvc/DVCModel.sln` and `dvc/DVCModel.vcxproj`.
3. Checked whether required dependency directories exist under `dvc/opensource/`.
4. Checked whether Windows build tools are available in the current environment.
5. Checked whether any previous build artifacts already exist in the workspace.

## Findings

### 1. The project is a Windows Visual Studio project

The checked-in build entrypoints are:

- `dvc/DVCModel.sln`
- `dvc/DVCModel.vcxproj`
- `dvc/Examples/windows/ExampleWindows/ExampleWindows.vcxproj`

The project file requires:

- Visual Studio project format
- MSVC toolset `v141`
- Windows SDK `10.0.17763.0`

This means the documented build path is Windows-specific.

### 2. Required dependencies are missing from the expected path

`dvc/README.md` and `dvc/DVCModel.vcxproj` expect:

- `dvc/opensource/hwpx-owpml-model`
- `dvc/opensource/jsoncpp`

But during this attempt:

- `dvc/opensource/` did not exist
- no dependency source tree or built libraries were present under `dvc/`

### 3. Required build tools are not installed in this environment

These checks failed:

- `which msbuild`
- `which devenv`
- `which cmake`

So the current environment cannot execute the README workflow as written.

### 4. No build outputs already exist

No files were found for:

- `DVCModel.dll`
- `DVCModel.lib`
- `jsoncpp.lib`
- `OWPML.lib`
- `OWPMLd.lib`

### 5. `update_oss.bat` cannot be relied on as-is

The dependency helper script has an obvious issue in the `jsoncpp` section:

- it enters `rapidjson`
- then runs the `jsoncpp` reset command there

So even on Windows, dependency preparation should be verified manually.

## Conclusion

The build is not possible in the current workspace environment.

Primary reasons:

1. The available environment is Linux/WSL, while the project is configured for Windows Visual Studio 2017.
2. The required Windows build tools are not installed.
3. The required dependency directories under `dvc/opensource/` are missing.
4. The dependency bootstrap script is not trustworthy without manual verification.

## Recommended Next Step

Use a Windows machine or Windows VM with Visual Studio 2017 C++ tooling, then follow the manual in [docs/dvc-build-guide.md](/home/kjhwan/Work/hwpx/docs/dvc-build-guide.md).
