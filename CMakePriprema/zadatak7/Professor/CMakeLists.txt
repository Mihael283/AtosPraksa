cmake_minimum_required(VERSION 3.0.0)
project(Professor VERSION 0.1.0)

include(CTest)
enable_testing()

file(GLOB SOURCES src/*.cpp)

include_directories(include)

add_library(${PROJECT_NAME} SHARED ${SOURCES})

install(TARGETS ${PROJECT_NAME} DESTINATION lib/${PROJECT_NAME})

set(CPACK_PROJECT_NAME ${PROJECT_NAME})
set(CPACK_PROJECT_VERSION ${PROJECT_VERSION})
include(CPack)
