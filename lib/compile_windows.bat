@echo off
set /p "VISUALDIR=Entrez le chemin d'installation de Visual Studio: "
if not "%VISUALDIR%" == "" goto :continue
set VISUALDIR=C:\Program Files\Microsoft Visual Studio\2022\Community

:continue
pushd "%VISUALDIR%\VC\Auxiliary\Build"
call vcvarsall.bat x64
popd

rem Compiling objects
cl /EHsc /c lib_while.cpp /I ./
rem Actual library compilation
lib /OUT:../compiler/while.lib lib_while.obj

rem Copying lib_while.h
copy "lib_while.h" "../compiler/lib_while.h"