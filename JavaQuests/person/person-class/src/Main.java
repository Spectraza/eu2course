
// Создать класс Person, который содержит: переменные fullName, age;методы move() и talk(),
// в которых просто вывести на консоль сообщение -"Такой-то  Person говорит". Добавьте два
// конструктора  - Person() и Person(fullName, age).Создайте два объекта этого класса.
// Один объект инициализируется конструктором Person(), другой - Person(fullName, age).
// Вызовите методы move() и talk().

public class Main {
    public static void main(String[] args)
    {
        Person person1 = new Person("Sans", 19);
        person1.move();
        person1.talk();

        Person person2 = new Person("Frisk", 19);
        person2.move();
        person2.talk();
    }
}