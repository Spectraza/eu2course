#ifndef SAVYCH_221_2_PR8_TRAIN_H
#define SAVYCH_221_2_PR8_TRAIN_H
#include <string> //підключення бібліотеки

class Train { //це класс поїзда, який ми створили
private://приватні дані

    std::string name; //змінна
    int trainNumber;//змінна
    time_t departureTime;//
public://публічні дані
    std::string *getName();//змінна для ім'я

    int getTrainNumber();//змінна для номеру

    time_t getDepartureTime();// визиваємо змінну для часу поїзда, в який він приїде

    Train(std::string name, int trainNumber, time_t departureTime); //створюємо змінні для поїзду
};

#endif //SAVYCH_221_2_PR8_TRAIN_H
