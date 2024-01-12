@echo off
set VISUALDIR=C:\Program Files\Microsoft Visual Studio\2022\Community

REM -- mise en place environnement Visual
pushd "%VISUALDIR%\VC\Auxiliary\Build"
call vcvarsall.bat x64
popd

cl /EHsc /c lib_while.cpp /I ./
lib /OUT:while.lib lib_while.obj