#include <iostream> //підключення бібліотеки для введення-вивделення інформацій
#include "Train.h" //підключення класу

//Варіант 3.
//
//1. Створити клас TRAIN, яка містить наступні поля:
//
//- Nazv – Назва
//
//- Numer – номер поїзда;
//
//- Date – дата відправлення
//
//- Time – час відправлення поїзда.
//



time_t getDate() { //створюємо функцію для отримання дати від кооисутвача
    printf("Gimme year\n"); // виводимо текст
    int year; //змінна рік
    std::cin >> year; // вводимо рік
    year -= 1901; //це для того, щоб нам показувало наш рік

    printf("Now month\n"); //також виводимо текст
    int month; //змінна місяць
    std::cin >> month; //вводимо місяць
    month += 1; //це щоб нам виводило поточний місяць

    printf("The day\n"); //теж виводимо текст
    int day; //змінна день
    std::cin >> day; //вводимо день

    printf("Hours\n");
    int hours; //змінна години
    std::cin >> hours; //вводимо години

    tm *time = new tm{ //змінна завдяки якій можна конкретно вивести конкретну інформацію про дату поїзда
            .tm_hour = hours,
            .tm_mday = day,
            .tm_mon = month,
            .tm_year =  year,
    };

    return mktime(time);//повертаємо змінну час
}

int getSize() {//створюємо функцію для створення поїздів
    printf("Please provide size of array of trains\n"); //виводимо текст

    int size; //змінна
    std::cin >> size; //вводимо кількість поїздів, скільки нам треба

    return size; //повертаємо змінну
}

Train **getTrains(int size) { //свторюємо функцію для отримання інформації створенних поїздів

    printf("You better give me %i trains\n", size); //виводимо текст

    auto **trains = new Train *[size]; //змінна поїзд

    std::string name; //змінна ім'я поїзда
    int trainNumber; //змінна його номера
    time_t time; //визимаємо функцію час
    for (int i = 0; i < size; ++i) { //створюємо цикл для введення даних всіх поїздів, в залежності від заданної кількості поїздів
        printf("Train #%i\n", i); //виводимо текст номера поїзда

        printf("Name of Train\n"); //просимо ввести ім'я поїзда
        std::cin >> name;//вводимо
        printf("Train number\n"); //треба ввести номер поїзда
        std::cin >> trainNumber; //вводимо його тут

        printf("Now the date\n"); // на яку дату потрібен поїзд
        time = getDate(); // далі на який час він потрібен

        auto *train = new Train(name, trainNumber, time); //змінна
        trains[i] = train; //присоюємо значення першої змінної до другої
    }

    return trains; //повертаємо змінну
}


void printTrain(Train *train) { //ця функція створена для виведення інформації про поїзд, який може приїхати в заданний час, який вам треба
    time_t time = train->getDepartureTime(); //вивзмаємо функцію час з классом
    printf("Name: %s, number: %i, departureTime: %s", train->getName()->c_str(), train->getTrainNumber(), ctime(&time)); //виводимо інформацію
}

bool *trainsAfterDate(Train **trains, int size) {// ця функція створена щоб дізнатися чи є інший поїзд щоб повернутися в інший день
    printf("Date after which trans to look\n"); //виводимо інформацію
    time_t date = getDate(); //визимавємо функцію дата

    bool *isAfter = new bool[size]; //змінна

    for (int i = 0; i < size; ++i) { //цикл здобуття інформації в який рік, місяць, день та годину потрібен поїзд
        double diff = difftime(trains[i]->getDepartureTime(), date); //змінна

        isAfter[i] = (diff > 0) && (diff < (60 * 60 * 24));
    }

    return isAfter; //повертаємо цю змінну
}

int main() {
    int size = getSize(); //змінна, в якій визимаємо функцію розмір

    Train **trains = getTrains(size); //визиваємо класс

    bool *goodTrains = trainsAfterDate(trains, size); //змінна

    for (int i = 0; i < size; ++i) { //створюєм цикл, що перевіряє який нам поїзд підходить
        if (goodTrains[i]) { //якщо підходить, виводимо його, якщо ні, перевіряємо ще раз
            printTrain(trains[i]);
        }
    }

    return 0; //повертаємо 0
}
