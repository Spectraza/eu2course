#include <iostream>

class IntArray {
private:
    int* data;
    int size;
public:

    IntArray() {
        size = 0;
        data = nullptr;
    }

    IntArray(int size) {
        this->size = size;
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = 0;
        }
    }


    ~IntArray() {
        delete[] data;
    }


    int& operator[](int index) {
        return data[index];
    }


    int getSize() {
        return size;
    }


    bool hasRemainder(int divisor) {
        for (int i = 0; i < size; i++) {
            if (data[i] % divisor != 0) {
                return true;
            }
        }
        return false;
    }
};

int main() {
    IntArray arr(5);
    arr[0] = 10;
    arr[1] = 20;
    arr[2] = 30;
    arr[3] = 40;
    arr[4] = 50;

    int divisor = 3;
    bool hasRemainder = arr.hasRemainder(divisor);

    std::cout << "The array has" << (hasRemainder ? " " : " no ") << "remainder(s) when divided by " << divisor << std::endl;

    return 0;
}

