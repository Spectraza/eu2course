public class Person {
    //    5 поля
    public int katya;

    private String name = "Lera";

    private final int number;

    //    6 конструктор
    public Person(int number)
    {
        this.number = number;
        this.katya = 5;
        System.out.println("Creating person");
    }
}
