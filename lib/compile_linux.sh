#!/bin/bash

echo Compiling...
g++ -c -o lib_while.o lib_while.cpp
ar rcs libwhile.a lib_while.o

echo Copying files...
cp libwhile.a ../compiler/
cp libwhile.a ../compiler/resources/
cp lib_while.h ../compiler/
cp lib_while.h ../compiler/resources/
echo Done.