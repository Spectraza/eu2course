
//1. Пользователь должен ввести свое имя
//
//2. Пользователь должен выбрать операцию (+, - , *, /, %, возведение в степень, квадратный корень)
//
//3. Пользователь должен значение (Пример: 2+2)
//
//4. Нужно округлить число до сотых
//5. Программа должна выдать результат

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        while (true) {

            System.out.print("Enter equation(2 + 2): ");
            String expression = scanner.nextLine();

            String[] parts = expression.split(" ");
            if (parts.length != 3) {
                System.out.println("That was incorrect");
                continue;
            }

            double num1 = Double.parseDouble(parts[0]);
            double num2 = Double.parseDouble(parts[2]);
            double result = 0.0;

            String operator = parts[1];
            switch (operator) {
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                case "*" -> result = num1 * num2;
                case "/" -> result = num1 / num2;
                case "%" -> result = num1 % num2;
                case "^" -> result = Math.pow(num1, num2);
                case "√" -> result = Math.pow(num1, 1 / num2);
                default -> {
                    System.out.println("I don't know this operation.");
                    scanner.close();
                    return;
                }
            }

            System.out.printf("Result: %.2f\n", result);

        }
    }
}