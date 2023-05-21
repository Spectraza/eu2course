#include <iostream>

template <typename T>
class Pair {
private:
    T first;
    T second;
public:
    Pair(T f, T s) : first(f), second(s) {}
    T getFirst() const { return first; }
    T getSecond() const { return second; }
};

int main() {
    Pair<int> pair1(10, 20);
    Pair<double> pair2(3.14, 2.71);

    std::cout << "First pair: " << pair1.getFirst() << ", " << pair1.getSecond() << std::endl;
    std::cout << "Second pair: " << pair2.getFirst() << ", " << pair2.getSecond() << std::endl;

    return 0;
}
