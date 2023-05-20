
// 1. В цикле программа просит у пользователя ввести два числа и выводит результат их умножения.
//После вывода результата умножения программа спрашивает, надо ли завершить выполнение.
// И если пользователь введет число 1, то программа завершает цикл. Если введено любое другое число,
// то программа продолжает спрашивать у пользователя два числа и умножать их.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            int result = num1 * num2;
            System.out.println("Multiplication result " + result);

            System.out.print("Type 1 to exit, or anything else to continue ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                break;
            }
        }

        scanner.close();

    }
}