cmake_minimum_required(VERSION 3.0.0)
project(Zadatak5 VERSION 0.1.0)

include(CTest)
enable_testing()



set(HEADER1 "/home/mihael/Documents/GitHub/AtosPraksa/CMakePriprema/zadatak5/include/Professor/")
set(HEADER2 "/home/mihael/Documents/GitHub/AtosPraksa/CMakePriprema/zadatak5/include/Student/")
file(GLOB MAIN "/home/mihael/Documents/GitHub/AtosPraksa/CMakePriprema/zadatak5/src/main.cpp")
file(GLOB STUDENT "/home/mihael/Documents/GitHub/AtosPraksa/CMakePriprema/zadatak5/src/Student.cpp")
file(GLOB PROF "/home/mihael/Documents/GitHub/AtosPraksa/CMakePriprema/zadatak5/src/Professor.cpp")
add_executable(zadatak5 ${MAIN} ${STUDENT} ${PROF} ${HEADER1} ${HEADER2})
target_link_libraries(zadatak5)

set(CPACK_PROJECT_NAME ${PROJECT_NAME})
set(CPACK_PROJECT_VERSION ${PROJECT_VERSION})
include(CPack)
