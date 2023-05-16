public class Person {
    //    5 поля

    private String name = "Lera";

    private final int age;

    //    6 конструктор
    public Person(int age)
    {
        this.age = age;
        System.out.println("Creating person");
    }
}
