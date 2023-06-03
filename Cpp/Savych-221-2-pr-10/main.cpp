#include <iostream>
#include <thread>
#include <vector>

void printEvenIndices(const std::vector<int>& nums) {
    for (size_t i = 0; i < nums.size(); i++) {
        if (i % 2 == 0) {
            std::cout << "T0, Index " << i << ": " << nums[i] << "\n";
        }
    }
}

void printOddIndicesSquares(const std::vector<int>& nums) {
    for (size_t i = 0; i < nums.size(); i++) {
        if (i % 2 != 0) {
            std::cout << "T1, Index " << i << ": " << nums[i]*nums[i] << "\n";
        }
    }
}

int main() {
    std::vector<int> numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    std::thread t0(printEvenIndices, std::ref(numbers));
    std::thread t1(printOddIndicesSquares, std::ref(numbers));

    t0.join();
    t1.join();

    return 0;
}