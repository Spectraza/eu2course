#include "Train.h"
#include <utility> //тут також підключення бібліотек

//тут повертаємо функції та присвоюємо ці функції до конкретних змінних

time_t Train::getDepartureTime() {
    return this->departureTime;
}

int Train::getTrainNumber() {
    return this->trainNumber;
}

std::string *Train::getName() {
    return &this->name;
}

Train::Train(std::string name, int trainNumber, time_t departureTime) {
    this->name = std::move(name);
    this->trainNumber = trainNumber;
    this->departureTime = departureTime;
}