
// Создайте класс Phone, который содержит переменные number,
// model и weight.Создайте три экземпляра этого класса.
// Выведите на консоль значения их переменных. Добавить
// в класс Phone методы: receiveCall, имеет один
// параметр – имя звонящего. Выводит на консоль
// сообщение “Звонит {name}”. Метод getNumber – возвращает
// номер телефона. Вызвать эти методы для каждого из объектов.
// Добавить конструктор в класс Phone, который принимает на
// вход три параметра для инициализации переменных класса - number,
// model и weight. Добавить конструктор, который принимает на вход
// два параметра для инициализации переменных класса - number, model.
// Добавить конструктор без параметров.Вызвать из конструктора с тремя
// параметрами конструктор с двумя. Добавьте перегруженный метод receiveCall,
// который принимает два параметра - имя звонящего и номер телефона звонящего.
// Вызвать этот метод. Создать метод sendMessage с аргументами переменной длины.
// Данный метод принимает на вход номера телефонов, которым будет отправлено сообщение.
// Метод выводит на консоль номера этих телефонов.


public class Main {
    public static void main(String[] args) {
        Phone phoneOne = new Phone("123456789", "iPhone", 0.3);
        Phone phoneTwo = new Phone("987654321", "Samsung", 0.4);
        Phone phoneThree = new Phone();

        System.out.println("Phone 1:");
        System.out.println("Number: " + phoneOne.getNumber());
        System.out.println("Model: " + phoneOne.model);
        System.out.println("Weight: " + phoneOne.weight);

        System.out.println();

        System.out.println("Phone 2:");
        System.out.println("Number: " + phoneTwo.getNumber());
        System.out.println("Model: " + phoneTwo.model);
        System.out.println("Weight: " + phoneTwo.weight);

        System.out.println();

        System.out.println("Phone 3:");
        System.out.println("Number: " + phoneThree.getNumber());
        System.out.println("Model: " + phoneThree.model);
        System.out.println("Weight: " + phoneThree.weight);

        System.out.println();

        phoneOne.receiveCall("Mark");
        phoneTwo.receiveCall("Alice", "987654321");

        System.out.println();

        phoneThree.sendMessage("111111111", "222222222", "333333333");
    }
}