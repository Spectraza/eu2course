public class TaskSeven {
    public static void main(String[] args) {
        // Дано трехзначное натуральное  число. Определить является ли
        // это число числом Армстронга, т.е. равна ли сумма третьих степеней
        // цифр  числа самому числу. Например, число 153=13+53+33  является числом Армстронга.

        System.out.println("Task 7");
        int num = 371;
        int num1 = 0;
        int num2;
        int sum = 0;

        while (num > 0) {
            num1 = num % 10;
            num2 = num1 * num1 * num1;
            sum += num2;

            num /= 10;
        }

        System.out.println(sum);

    }
}
