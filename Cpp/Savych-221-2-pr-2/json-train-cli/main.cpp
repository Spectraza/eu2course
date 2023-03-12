#include <iostream>
#include <fstream>
#include <iomanip>
#include <sstream>
#include "Train.h"

void addTrainToJson(const std::string &filename) {
    std::string name;
    int number;
    std::string departure_str;

    std::cout << "Enter train name: ";
    std::getline(std::cin, name);

    std::cout << "Enter train number: ";
    std::string number_str;
    std::getline(std::cin, number_str);
    std::stringstream number_ss(number_str);
    if (!(number_ss >> number)) {
        std::cerr << "Error: invalid train number \"" << number_str << "\". Please enter an integer." << std::endl;
        return;
    }

    std::cout << "Enter departure date and time (YYYY-MM-DD HH:MM:SS): ";
    std::getline(std::cin, departure_str);

    std::tm departure_tm = {};
    std::stringstream ss(departure_str);
    ss >> std::get_time(&departure_tm, "%Y-%m-%d %H:%M:%S");
    if (ss.fail()) {
        std::cerr << "Error: invalid date/time format. Please use the format YYYY-MM-DD HH:MM:SS." << std::endl;
        return;
    }

    auto departure = std::chrono::system_clock::from_time_t(std::mktime(&departure_tm));

    Train train(name, number, departure);

    nlohmann::json j;

    std::ifstream file(filename);
    if (file.is_open()) {
        if (file.peek() != std::ifstream::traits_type::eof()) {
            try {
                j = nlohmann::json::parse(file);
            } catch (const nlohmann::json::parse_error &e) {
                std::cerr << "Error: could not parse existing JSON file \"" << filename << "\": " << e.what()
                          << std::endl;
                return;
            }
            if (!j.is_array()) {
                std::cerr << "Error: existing JSON file \"" << filename << "\" is not an array." << std::endl;
                return;
            }
        }
    }

    j.push_back(train.toJson());

    std::ofstream outfile(filename);
    if (!outfile.is_open()) {
        std::cerr << "Error: could not open file \"" << filename << "\" for writing." << std::endl;
        return;
    }
    outfile << j.dump(4) << std::endl;

    std::cout << "Train added to file \"" << filename << "\"." << std::endl;
}


void readTrainsFromJson(const std::string &filename) {
    std::ifstream input_file(filename);
    nlohmann::json j;
    std::vector<Train> trains;

    if (input_file >> j) {
        try {
            for (const auto &train_json: j) {
                Train train(train_json);
                trains.push_back(train);
            }

            for (const auto &train: trains) {
                std::cout << "Name: " << train.getName() << std::endl;
                std::cout << "Number: " << train.getNumber() << std::endl;
                std::time_t departure_time = std::chrono::system_clock::to_time_t(train.getDeparture());
                std::cout << "Departure time: " << std::put_time(std::localtime(&departure_time), "%F %T") << std::endl;
                std::cout << std::endl;
            }
        }
        catch (const nlohmann::json::exception &e) {
            std::cerr << "Error: could not parse JSON file " << filename << ": " << e.what() << std::endl;
        }
    } else {
        std::cerr << "Error: could not open file " << filename << std::endl;
    }
}

void showUpcomingTrains(std::string filename) {
    std::ifstream input(filename);
    if (!input.is_open()) {
        std::cout << "Could not open file " << filename << std::endl;
        return;
    }

    nlohmann::json j;
    input >> j;

    if (j.empty()) {
        std::cout << "No trains found in file " << filename << std::endl;
        return;
    }

    std::vector<Train> trains;
    for (const auto &train_json: j) {
        trains.emplace_back(train_json);
    }

    std::string date_str;
    std::chrono::system_clock::time_point user_date;
    bool valid_input = false;
    while (!valid_input) {
        std::cout << "Enter a date and time in the format YYYY-MM-DD HH:MM:SS: ";
        std::getline(std::cin, date_str);
        std::tm timeinfo = {};
        std::istringstream ss(date_str);
        ss >> std::get_time(&timeinfo, "%Y-%m-%d %H:%M:%S");
        if (ss.fail()) {
            std::cout << "Invalid date format" << std::endl;
        } else {
            user_date = std::chrono::system_clock::from_time_t(std::mktime(&timeinfo));
            valid_input = true;
        }
    }

    std::vector<Train> upcoming_trains;
    std::copy_if(trains.begin(), trains.end(), std::back_inserter(upcoming_trains), [user_date](const Train &train) {
        return train.getDeparture() > user_date;
    });

    if (upcoming_trains.empty()) {
        std::cout << "No upcoming trains found" << std::endl;
        return;
    }

    std::cout << "Upcoming trains:" << std::endl;
    for (const auto &train: upcoming_trains) {
        std::cout << "Name: " << train.getName() << std::endl;
        std::cout << "Number: " << train.getNumber() << std::endl;
        std::time_t departure_time = std::chrono::system_clock::to_time_t(train.getDeparture());
        std::cout << "Departure time: " << std::put_time(std::localtime(&departure_time), "%F %T") << std::endl;
        std::cout << std::endl;
    }
}


void deleteTrainByNumber(std::string filename) {
    std::ifstream input(filename);
    if (!input.is_open()) {
        std::cout << "Could not open file " << filename << std::endl;
        return;
    }

    nlohmann::json j;
    input >> j;

    if (j.empty()) {
        std::cout << "No trains found in file " << filename << std::endl;
        return;
    }

    std::string trainNumberStr;
    std::cout << "Enter the train number to delete: ";
    std::getline(std::cin, trainNumberStr);

    int trainNumber;
    try {
        trainNumber = std::stoi(trainNumberStr);
    } catch (const std::exception &e) {
        std::cout << "Invalid input, please try again" << std::endl;
        return;
    }

    auto it = std::find_if(j.begin(), j.end(), [trainNumber](const nlohmann::json &trainJson) {
        return trainJson["number"].get<int>() == trainNumber;
    });

    if (it == j.end()) {
        std::cout << "Train with number " << trainNumber << " not found" << std::endl;
        return;
    }

    j.erase(it);

    std::ofstream output(filename);
    output << j.dump(4) << std::endl;

    std::cout << "Train with number " << trainNumber << " deleted successfully" << std::endl;
}


int main() {
    std::string filename = "trains.json";

    std::ifstream file(filename);
    bool fileExists = file.good();

    if (!fileExists) {
        std::ofstream newFile(filename);
        newFile << "[]" << std::endl;
        newFile.close();
    }

    std::cout << "Welcome to the Train Manager app" << std::endl;

    bool exitProgram = false;

    while (!exitProgram) {
        std::cout << "JSON file name: " << filename << std::endl;
        std::cout << "Choose an option:" << std::endl;
        std::cout << "1. Add train" << std::endl;
        std::cout << "2. Read trains" << std::endl;
        std::cout << "3. Show upcoming trains" << std::endl;
        std::cout << "4. Delete train" << std::endl;
        std::cout << "5. Change file name" << std::endl;
        std::cout << "6. Exit" << std::endl;

        std::string input;
        std::getline(std::cin, input);

        try {
            int choice = std::stoi(input);
            if (choice == 1) {
                addTrainToJson(filename);
            } else if (choice == 2) {
                readTrainsFromJson(filename);
            } else if (choice == 3) {
                showUpcomingTrains(filename);
            } else if (choice == 4) {
                deleteTrainByNumber(filename);
            } else if (choice == 5) {
                std::cout << "Enter new JSON file name: ";
                std::getline(std::cin, filename);
                std::ifstream file(filename);
                if (!file) {
                    std::ofstream outfile(filename);
                    outfile << "[]";
                    outfile.close();
                }
            } else if (choice == 6) {
                std::cout << "Exiting Train Manager app" << std::endl;
                exitProgram = true;
            } else {
                std::cout << "Invalid choice, please try again" << std::endl;
            }
        } catch (std::invalid_argument &) {
            std::cout << "Invalid input, please try again" << std::endl;
        }
    }

    return 0;
}