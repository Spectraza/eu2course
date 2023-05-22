#include <iostream>
#include <vector>

int g(std::vector<int>& container) {
    int changes = 0;
    int size = container.size();

    for (int i = size - 1; i >= 1; i -= 2) {
        if (container[i] < container[i - 1]) {
            std::swap(container[i], container[i - 1]);
            changes++;
        }
    }

    for (int element : container) {
        std::cout << element << " ";
    }
    std::cout << std::endl;

    return changes;
}

int main() {
    std::vector<int> container = {4, 2, 6, 1, 8, 9};
    int numChanges = g(container);
    std::cout << "Number of changed values: " << numChanges << std::endl;

    return 0;
}