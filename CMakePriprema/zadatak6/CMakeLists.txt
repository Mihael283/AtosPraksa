cmake_minimum_required(VERSION 3.0.0)
project(Zadatak6 VERSION 0.1.0)

include(CTest)
enable_testing()




file(GLOB MAIN "/home/mihael/Documents/GitHub/AtosPraksa/CMakePriprema/zadatak6/src/main.cpp")

#add_library(Professor SHARED1 src/Professor.cpp)
#add_library(Student SHARED2 src/Student.cpp)

#install(TARGETS ${SHARED1} ${SHARED2} DESTINATION /lib)

find_library(LIBPROF libProfessor.so)
find_library(LIBSTUD libStudent.so)
add_executable(zadatak6 ${MAIN})
target_link_libraries(zadatak6 PRIVATE ${LIBPROF} ${LIBSTUD})

set(CPACK_PROJECT_NAME ${PROJECT_NAME})
set(CPACK_PROJECT_VERSION ${PROJECT_VERSION})
include(CPack)
