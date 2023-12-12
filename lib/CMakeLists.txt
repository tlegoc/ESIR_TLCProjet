cmake_minimum_required(VERSION 3.25)

project(WHILE_RUNTIME)

add_library(while STATIC lib_while.cpp lib_while.h)
set_target_properties(while PROPERTIES ARCHIVE_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/)
