cmake_minimum_required(VERSION 3.0.0)
project(Zadatak6 VERSION 0.1.0)

include(CTest)
enable_testing()

set(SOURCE_DIR src)
set(SOURCE ${SOURCE_DIR}/main.cpp)
    
find_library(LIBPROF libProfessor.so)
find_library(LIBSTUD libStudent.so)
add_executable(zadatak6 ${SOURCE})
target_link_libraries(zadatak6 PRIVATE ${LIBPROF} ${LIBSTUD})

set(CPACK_PROJECT_NAME ${PROJECT_NAME})
set(CPACK_PROJECT_VERSION ${PROJECT_VERSION})
include(CPack)
