#include <iostream>

class Number {
public:
    virtual Number *add(Number *other) = 0;

    virtual Number *subtract(Number *other) = 0;

    virtual Number *multiply(Number *other) = 0;

    virtual Number *divide(Number *other) = 0;
};

class Integer : public Number {
private:
    int value;
public:
    Integer(int val) : value(val) {}

    Number *add(Number *other) override {
        Integer *i = dynamic_cast<Integer *>(other);
        if (i) {
            return new Integer(value + i->value);
        } else {
            // throw some exception or handle error
        }
    }

    Number *subtract(Number *other) override {
        Integer *i = dynamic_cast<Integer *>(other);
        if (i) {
            return new Integer(value - i->value);
        } else {
            // throw some exception or handle error
        }
    }

    Number *multiply(Number *other) override {
        Integer *i = dynamic_cast<Integer *>(other);
        if (i) {
            return new Integer(value * i->value);
        } else {
            // throw some exception or handle error
        }
    }

    Number *divide(Number *other) override {
        Integer *i = dynamic_cast<Integer *>(other);
        if (i) {
            return new Integer(value / i->value);
        } else {
            // throw some exception or handle error
        }
    }
};

class Real : public Number {
private:
    double value;
public:
    Real(double val) : value(val) {}

    Number *add(Number *other) override {
        Real *r = dynamic_cast<Real *>(other);
        if (r) {
            return new Real(value + r->value);
        } else {
//            throw some exception or handle error
        }
    }

    Number *subtract(Number *other) override {
        Real *r = dynamic_cast<Real *>(other);
        if (r) {
            return new Real(value - r->value);
        } else {
//              throw some exception or handle error
        }
    }

    Number *multiply(Number *other) override {
        Real *r = dynamic_cast<Real *>(other);
        if (r) {
            return new Real(value * r->value);
        } else {
//              throw some exception or handle error
        }
    }

    Number *divide(Number *other) override {
        Real *r = dynamic_cast<Real *>(other);
        if (r) {
            return new Real(value / r->value);
        } else {
//              throw some exception or handle error
        }
    }
};

int main() {
    Number *i1 = new Integer(5);
    Number *i2 = new Integer(3);
    Number *r1 = new Real(2.5);
    Number *r2 = new Real(1.5);

    Number *sum1 = i1->add(i2); // returns a new Integer object with value 8
    Number *sum2 = r1->add(r2); // returns a new Real object with value 4.0

    std::cout << "Integer addition: " << dynamic_cast<Integer *>(sum1)->getValue() << std::endl;
    std::cout << "Real addition: " << dynamic_cast<Real *>(sum2)->getValue() << std::endl;

    delete i1;
    delete i2;
    delete r1;
    delete r2;
    delete sum1;
    delete sum2;

    return 0;
}