//
// Created by savyc on 12.03.2023.
//

#include "Train.h"

Train::Train(const std::string &name, int number, const std::chrono::system_clock::time_point &departure)
        : name(name), number(number), departure(departure) {
}

Train::Train(const nlohmann::json &j)
        : name(j["name"]), number(j["number"]) {
    auto departure_time_t = j["departure"].get<std::time_t>();
    departure = std::chrono::system_clock::from_time_t(departure_time_t);
}

std::string Train::getName() const {
    return name;
}

int Train::getNumber() const {
    return number;
}

std::chrono::system_clock::time_point Train::getDeparture() const {
    return departure;
}

std::string Train::toString() const {
    return name + " " + std::to_string(number) + " " + std::to_string(std::chrono::system_clock::to_time_t(departure));
}

nlohmann::json Train::toJson() const {
    return {{"name",      name},
            {"number",    number},
            {"departure", std::chrono::system_clock::to_time_t(departure)}};
}


