import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        double a = keyboard.nextDouble();
        double b = keyboard.nextDouble();

        double s = Math.pow(a, 2) + b * b;
        System.out.println("Hypotenuse is " + s);


    }
}