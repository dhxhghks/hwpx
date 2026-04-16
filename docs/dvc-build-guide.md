# DVC Build Guide

## Purpose

This document is the step-by-step manual for building the `dvc/` project in this workspace.

Here, `dvc/` means Hancom's `HWPX Document Validation Checker`, a Windows-first C++ DLL project. It is not related to Data Version Control.

## Scope

This guide is based on the repository contents in this workspace:

- `dvc/DVCModel.sln`
- `dvc/DVCModel.vcxproj`
- `dvc/Examples/windows/ExampleWindows/ExampleWindows.vcxproj`
- `dvc/README.md`
- `dvc/update_oss.bat`

The documented build target is:

- `DVCModel.dll`
- `DVCModel.lib`

Optionally, you can also build the demo console app:

- `Examples/windows/ExampleWindows`

## Build Environment

The project is configured for Windows and Visual Studio 2017.

Required environment:

1. Windows 10 or a compatible Windows environment
2. Visual Studio 2017 with C++ workload
3. MSVC toolset `v141`
4. Windows SDK matching or compatible with `10.0.17763.0`
5. CMake
6. Git

## Required Dependencies

The DVC project depends on:

1. `hwpx-owpml-model`
2. `jsoncpp`

The project file expects these under the `dvc/opensource/` directory:

- `dvc/opensource/hwpx-owpml-model`
- `dvc/opensource/jsoncpp`

This matters because `DVCModel.vcxproj` contains hard-coded include and library search paths under `opensource/...`.

## Important Notes Before You Start

### 1. This is a Windows-first build

The checked-in solution and project files are Visual Studio projects. There is no CMake build for DVC itself in this repository.

### 2. Dependency layout is mandatory

Even though this workspace already has a sibling directory named `hwpx-owpml-model/`, DVC does not reference that sibling path directly. By default, it expects OWPML inside:

- `dvc/opensource/hwpx-owpml-model`

If you do not place the dependency there, Visual Studio include/lib resolution will fail.

### 3. `update_oss.bat` is not sufficient by itself

The batch file clones dependencies into `dvc/opensource/`, but there is an obvious bug in the `jsoncpp` section: it changes into `rapidjson` before running `git reset` for the jsoncpp revision.

That means:

- you should not assume `update_oss.bat` fully prepares `jsoncpp`
- you should verify `jsoncpp` manually after running it

### 4. `jsoncpp` must be built first

The DVC README explicitly states that `jsoncpp` needs a generated Windows Visual Studio project and a built library before DVC can link successfully.

## Step-By-Step Manual

Follow this sequence on Windows.

### Step 1. Prepare the Windows toolchain

Install these first:

1. Windows 10 or a compatible Windows environment
2. Visual Studio 2017 with Desktop development for C++
3. MSVC toolset `v141`
4. Windows SDK compatible with `10.0.17763.0`
5. Git
6. CMake

Before going further, verify these commands work in a Developer Command Prompt:

```bat
where git
where cmake
where msbuild
```

### Step 2. Open a Windows shell in the `dvc/` directory

Work from the DVC repository root:

```bat
cd /d <workspace>\dvc
```

Expected files here:

- `DVCModel.sln`
- `DVCModel.vcxproj`
- `README.md`

### Step 3. Create the dependency directory layout

Create `opensource/` if it does not exist:

```bat
mkdir opensource
```

After setup, you want this layout:

```text
dvc/
  opensource/
    hwpx-owpml-model/
    jsoncpp/
```

### Step 4. Populate `hwpx-owpml-model`

You have two practical options.

Option A: clone directly under `dvc/opensource/`

```bat
cd /d <workspace>\dvc\opensource
git clone https://github.com/hancom-io/hwpx-owpml-model.git
```

Option B: copy the already-present sibling repository from this workspace into `dvc/opensource/`

Current sibling source in this workspace:

- `/home/kjhwan/Work/hwpx/hwpx-owpml-model`

On Windows, the equivalent would be to copy that repository into:

- `<workspace>\dvc\opensource\hwpx-owpml-model`

The important part is the final path, not how you got it there.

### Step 5. Populate `jsoncpp`

Clone `jsoncpp` under `dvc/opensource/`:

```bat
cd /d <workspace>\dvc\opensource
git clone https://github.com/open-source-parsers/jsoncpp.git
```

If you want to match the revision hinted by `update_oss.bat`, reset it manually inside the correct repository:

```bat
cd /d <workspace>\dvc\opensource\jsoncpp
git reset --hard 8190e061bc2d95da37479a638aa2c9e483e58ec6
```

### Step 6. Generate a Visual Studio solution for `jsoncpp`

The DVC README provides the intended approach. From the `jsoncpp` directory:

```bat
cd /d <workspace>\dvc\opensource\jsoncpp
cmake -S . -B json_git -G "Visual Studio 15 2017 Win64"
```

This should create:

- `dvc/opensource/jsoncpp/json_git/jsoncpp.sln`

### Step 7. Build `jsoncpp`

Open the generated `jsoncpp.sln` in Visual Studio 2017 and build the `jsoncpp_lib` project.

You can also build it from the command line:

```bat
cd /d <workspace>\dvc\opensource\jsoncpp\json_git
msbuild jsoncpp.sln /p:Configuration=Release /p:Platform=Win32
```

What you need to confirm afterward:

- `jsoncpp.lib`
- `jsoncpp.dll` if the chosen config produces one

The DVC README explicitly says to confirm the library outputs.

### Step 8. Build `hwpx-owpml-model`

Open the OWPML solution:

- `dvc/opensource/hwpx-owpml-model/Owpml.sln`

Build the configuration you intend DVC to use.

Command-line example:

```bat
cd /d <workspace>\dvc\opensource\hwpx-owpml-model
msbuild Owpml.sln /p:Configuration=Debug /p:Platform=Win32
```

What DVC expects from OWPML:

- Debug builds link against `OWPMLd.lib`, `OWPMLApi.lib`, `OWPMLUtil.lib`
- Release builds link against `OWPML.lib`, `OWPMLApi.lib`, `OWPMLUtil.lib`

The checked-in DVC project references these output directories:

- Debug: `opensource\hwpx-owpml-model\Build\BinDebug`
- Release: `opensource\hwpx-owpml-model\Build\Bin`

So after building OWPML, verify that those directories actually contain the required `.lib` files.

### Step 9. Verify DVC dependency paths before building

Before opening DVC in Visual Studio, verify these assumptions:

1. `dvc/opensource/hwpx-owpml-model` exists
2. `dvc/opensource/jsoncpp` exists
3. `jsoncpp` include files are available under a path matching the project settings
4. OWPML `.lib` files exist in `Build/BinDebug` or `Build/Bin`

Pay attention here:

- `DVCModel.vcxproj` uses different include/library conventions depending on configuration
- some Win32 entries reference `./opensource/jsoncpp/include/json`
- some other entries reference `./opensource/vcpkg/packages/jsoncpp_x86-windows/...`

That means the project file is not fully consistent across configurations.

For the least surprise, use the configuration that best matches the explicit README workflow and then confirm or adjust project properties in Visual Studio if paths do not resolve.

### Step 10. Open and build `DVCModel.sln`

Open:

- `dvc/DVCModel.sln`

Recommended initial target:

1. Configuration: `Debug` or `Release`
2. Platform: `Win32`

Then build the solution.

Command-line example:

```bat
cd /d <workspace>\dvc
msbuild DVCModel.sln /p:Configuration=Debug /p:Platform=Win32
```

Expected outputs:

- `DVCModel.dll`
- `DVCModel.lib`

The README states these are the primary artifacts.

### Step 11. Confirm outputs

After a successful build, confirm these files exist:

- `dvc\Debug\DVCModel.dll` or `dvc\Release\DVCModel.dll`
- `dvc\Debug\DVCModel.lib` or `dvc\Release\DVCModel.lib`

If they do not exist, stop and inspect the Visual Studio build output before moving on.

### Step 12. If linking fails, inspect project settings immediately

The most likely failure points are:

1. missing `jsoncpp.lib`
2. missing `OWPML*.lib`
3. include path mismatch under `opensource/...`
4. platform mismatch between built dependencies and DVC

Check these Visual Studio properties in `DVCModel.vcxproj`:

1. `C/C++ -> Additional Include Directories`
2. `Linker -> Additional Library Directories`
3. `Linker -> Input -> Additional Dependencies`

Do not continue until all dependency paths resolve cleanly for the exact configuration you are building.

## Suggested Configuration Strategy

If you want the fewest moving parts, use one consistent target across all projects.

Recommended choice:

1. Build `jsoncpp` for `Win32` or `x64`
2. Build `hwpx-owpml-model` for the same platform
3. Build `DVCModel` for the same platform
4. Avoid mixing `Win32` and `x64`

Because the checked-in DVC project includes more explicit Win32 library settings than x64, `Win32` is the safer first attempt unless you intend to normalize the project files yourself.

## Optional: Build the Demo Application

After `DVCModel` builds, you can build the example app.

Open:

- `dvc/Examples/windows/ExampleWindows/ExampleWindows.vcxproj`

Or open its solution if you are using the README's path:

- `dvc/examples/windows/ExampleWindows.sln`

The example project links against:

- `..\..\..\Debug\DVCModel.lib` for Debug Win32
- `..\..\..\Release\DVCModel.lib` for Release Win32

So build the example with the same configuration as the DVC DLL you already built.

Command-line example:

```bat
cd /d <workspace>\dvc\Examples\windows\ExampleWindows
msbuild ExampleWindows.vcxproj /p:Configuration=Debug /p:Platform=Win32
```

## Basic Runtime Test

The README shows the intended usage pattern:

1. prepare a checklist JSON file
2. provide a target `.hwpx` file
3. choose output options
4. run validation

Example assets already present in this repository:

- `dvc/sample/jsonFullSpec.json`
- `dvc/sample/test.json`
- `dvc/Examples/windows/ExampleWindows/test.json`

The documented command pattern is:

```text
-j --file=<output.json> -s -t <spec.json> <target.hwpx>
```

Meaning:

1. `-j`: JSON output
2. `--file=...`: write result to file
3. `-s`: simple mode
4. `-t`: table-focused output option
5. first path: checklist spec JSON
6. second path: target HWPX document

## Minimal Manual Checklist

If you only need the shortest safe sequence, do this:

1. Create `dvc\opensource`.
2. Put `hwpx-owpml-model` into `dvc\opensource\hwpx-owpml-model`.
3. Clone `jsoncpp` into `dvc\opensource\jsoncpp`.
4. Generate `jsoncpp.sln` with CMake for `Visual Studio 15 2017 Win64` or the platform you actually plan to use.
5. Build `jsoncpp`.
6. Build `hwpx-owpml-model`.
7. Build `DVCModel.sln`.
8. Verify `DVCModel.dll` and `DVCModel.lib`.

## Troubleshooting Checklist

If DVC does not build, check these in order.

### Build fails with missing headers

Likely cause:

- `opensource/hwpx-owpml-model` or `opensource/jsoncpp` is not in the expected place

Action:

- fix `Additional Include Directories`
- verify the directory tree under `dvc/opensource/`

### Build fails with missing `.lib` files

Likely cause:

- `jsoncpp` or `hwpx-owpml-model` was cloned but not built

Action:

- build those dependencies first
- verify the output directories referenced by `DVCModel.vcxproj`

### Build fails only for `x64`

Likely cause:

- project settings are less complete for `x64`
- dependency outputs do not match the selected platform

Action:

- try `Win32` first
- or normalize the x64 include/lib paths in project properties

### `update_oss.bat` completes but dependencies are still wrong

Likely cause:

- the script has a `jsoncpp` section bug

Action:

- inspect `dvc/opensource/jsoncpp` manually
- run clone/reset/build steps yourself instead of trusting the batch file

## Recommended End State

A successful setup should leave you with:

1. `dvc/opensource/hwpx-owpml-model` populated and built
2. `dvc/opensource/jsoncpp` populated and built
3. `dvc/DVCModel.sln` building successfully
4. `DVCModel.dll` and `DVCModel.lib` produced
5. optionally, the Windows example app also building and running

## Bottom Line

To build DVC successfully, do the work in this order:

1. prepare a Windows Visual Studio 2017 environment
2. place `hwpx-owpml-model` and `jsoncpp` under `dvc/opensource/`
3. generate and build `jsoncpp`
4. build `hwpx-owpml-model`
5. build `dvc/DVCModel.sln`
6. build the example app only after the DLL links cleanly

The critical detail is that DVC is not self-contained. Its success depends mostly on getting the dependency locations, build configurations, and library outputs aligned with the paths hard-coded in `DVCModel.vcxproj`.
