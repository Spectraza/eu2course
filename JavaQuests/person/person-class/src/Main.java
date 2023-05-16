import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        1 Создание переменных
        int name = 5;
        double e = 2.7;
        String wow = "WorldOfWarcraft";

//        2 ифы
        boolean condition1 = true;
        boolean condition2 = true;

        if (condition1) {
            System.out.println("Condition 1 is true!");
        } else if (condition2) {
            System.out.println("Condition 1 should be false but condition 2 is true");
        } else {
            System.out.println("Everything is false");
        }

//        3 циклы
        int a = 0;


//        вызовы функций
        Main main = new Main();

        main.sayHi();

        main.greet("Lera");

        System.out.println(main.add(2, 2));
    }

    //    4 функции
    private void sayHi() {
        System.out.println("Hi");
    }

    private void greet(String name) {
        System.out.println("Hello, " + name);
    }

    private int add(int a, int b) {
        return a + b;
    }
}