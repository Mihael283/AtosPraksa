cmake_minimum_required(VERSION 3.0.0)
project(Zadatak5 VERSION 0.1.0)

include(CTest)
enable_testing()


set(SOURCE_DIR src)
set(SOURCEMAIN ${SOURCE_DIR}/main.cpp)
set(SOURCEPROF ${SOURCE_DIR}/Professor.cpp)
set(SOURCESTUD ${SOURCE_DIR}/Student.cpp)
    
add_executable(zadatak5 ${SOURCEMAIN} ${SOURCEPROF} ${SOURCESTUD})


set(CPACK_PROJECT_NAME ${PROJECT_NAME})
set(CPACK_PROJECT_VERSION ${PROJECT_VERSION})
include(CPack)
