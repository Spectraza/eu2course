#include <iostream>

class B1 {
protected:
    int b1;

public:
    explicit B1(int b1_val) : b1(b1_val) {}

    void show() const {
        std::cout << "B1 value: " << b1 << std::endl;
    }
};

class B2 {
protected:
    int b2;

public:
    explicit B2(int b2_val) : b2(b2_val) {}

    void show() const {
        std::cout << "B2 value: " << b2 << std::endl;
    }
};

class B3 {
protected:
    int b3;

public:
    explicit B3(int b3_val) : b3(b3_val) {}

    void show() const {
        std::cout << "B3 value: " << b3 << std::endl;
    }
};

class D1 : public B2, protected B1 {
protected:
    int d1;

public:
    D1(int d1_val, int b1_val, int b2_val) : d1(d1_val), B1(b1_val), B2(b2_val) {}

    virtual void show() {
        std::cout << "D1 value: " << d1 << std::endl;
        B1::show();
        B2::show();
    }
};

class D2 : public D1, protected B3 {
protected:
    int d2;

public:
    D2(int d2_val, int d1_val, int b1_val, int b2_val, int b3_val)
            : d2(d2_val), D1(d1_val, b1_val, b2_val), B3(b3_val) {}

    void show() override {
        std::cout << "D2 value: " << d2 << std::endl;
        D1::show();
        B3::show();
    }
};

class D3 : public D2 {
protected:
    int d3;

public:
    D3(int d3_val, int d2_val, int d1_val, int b1_val, int b2_val, int b3_val)
            : d3(d3_val), D2(d2_val, d1_val, b1_val, b2_val, b3_val) {}

    void show() override {
        std::cout << "D3 value: " << d3 << std::endl;
        D2::show();
    }
};


int main() {
    std::cout << std::endl << "----- B1 -----" << std::endl;
    B1 b1_obj(10);
    b1_obj.show();

    std::cout << std::endl << "----- B2 -----" << std::endl;
    B2 b2_obj(20);
    b2_obj.show();

    std::cout << std::endl << "----- B3 -----" << std::endl;
    B3 b3_obj(30);
    b3_obj.show();

    std::cout << std::endl << "----- D1 -----" << std::endl;
    D1 d1_obj(40, 50, 60);
    d1_obj.show();

    std::cout << std::endl << "----- D2 -----" << std::endl;
    D2 d2_obj(70, 80, 90, 100, 110);
    d2_obj.show();

    std::cout << std::endl << "----- D3 -----" << std::endl;
    D3 d3_obj(120, 130, 140, 150, 160, 170);
    d3_obj.show();

    return 0;
}