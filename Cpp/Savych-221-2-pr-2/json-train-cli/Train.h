//
// Created by savyc on 12.03.2023.
//

#ifndef JSON_TRAIN_CLI_TRAIN_H
#define JSON_TRAIN_CLI_TRAIN_H

#include <string>
#include <chrono>
#include "lib/json.hpp"

using json = nlohmann::json;
using namespace std::chrono_literals;

#include <string>
#include <chrono>
#include "lib/json.hpp"

class Train {
public:
    Train(const std::string &name, int number, const std::chrono::system_clock::time_point &departure);

    Train(const nlohmann::json &j);

    std::string getName() const;

    int getNumber() const;

    std::chrono::system_clock::time_point getDeparture() const;

    std::string toString() const;

    nlohmann::json toJson() const;

private:
    std::string name;
    int number;
    std::chrono::system_clock::time_point departure;
};


#endif //JSON_TRAIN_CLI_TRAIN_H
