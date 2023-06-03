#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <filesystem>
#include "json.hpp"

using json = nlohmann::json;

std::string findTopScorers(const std::string& filename) {

    if (!std::filesystem::exists(filename)) {
        throw std::runtime_error("File not found: " + filename);
    }

    std::ifstream f(filename);

    if (!f.is_open()) {
        throw std::runtime_error("Unable to open file: " + filename);
    }

    json data;

    try {
        data = json::parse(f);
    } catch (json::parse_error& e) {
        throw std::runtime_error("JSON parse error: " + std::string(e.what()));
    }

    std::map<std::string, int> goalOccurrences;
    std::string mostOccurredName;
    int maxOccurrences = 0;

    for (const auto &match: data) {
        for (const auto &goal: match["goals"]) {
            std::string name = goal["name"];
            goalOccurrences[name]++;

            if (goalOccurrences[name] > maxOccurrences) {
                maxOccurrences = goalOccurrences[name];
                mostOccurredName = name;
            }
        }
    }

    return mostOccurredName;
}

int main() {
    std::string filePath = "/home/lera/projects/eu2course/Cpp/Savych-221-2-pr-9/test.json";
    try {
        std::cout << findTopScorers(filePath);
    } catch (std::exception& e) {
        std::cerr << "An error occurred: " << e.what() << std::endl;
        return 1;
    }

    return 0;
}
