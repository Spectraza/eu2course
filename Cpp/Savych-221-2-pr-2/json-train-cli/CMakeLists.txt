cmake_minimum_required(VERSION 3.24)
project(json_train_cli)

set(CMAKE_CXX_STANDARD 20)

add_executable(json_train_cli main.cpp Train.cpp Train.h)
