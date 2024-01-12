cmake_minimum_required(VERSION 3.25)

project(WHILE_RUNTIME)

add_library(while STATIC lib_while.cpp lib_while.h)
set_target_properties(while PROPERTIES ARCHIVE_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/)

set_property(TARGET while PROPERTY
        MSVC_RUNTIME_LIBRARY "MultiThreaded$<$<CONFIG:Debug>:Debug>")

# If debug add _d to the end of the library name
set_target_properties(while PROPERTIES DEBUG_POSTFIX "_d")