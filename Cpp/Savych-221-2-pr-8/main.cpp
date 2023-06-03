#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include "json.hpp"

using json = nlohmann::json;

std::string findTopScorers(const std::string& filename) {

    std::ifstream f(filename);
    json data = json::parse(f);
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
    std::string filePath = "/home/lera/projects/eu2course/Cpp/Savych-221-2-pr-8/test.json";
    std::cout << findTopScorers(filePath);
    return 0;
}