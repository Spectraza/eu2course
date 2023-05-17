
// Найти все трехзначные числа Амстронга - сумма кубов цифр которых равна самому числу.

public class TaskEleven {
    public static void main(String[] args){
        for (int number = 100; number <= 999; number++)
        {
            if (isArmstrongNumber(number))
            {
                System.out.println(number);
            }
        }
    }

    public static boolean isArmstrongNumber(int number)
    {
        int originalNumber = number;
        int sum = 0;

        while (number > 0)
        {
            int digit = number % 10;
            sum += Math.pow(digit, 3);
            number = number / 10;
        }

        return originalNumber == sum;
    }
}
