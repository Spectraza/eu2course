
// Дано натуральное число N. Определить, является ли оно палиндромом.

public class TaskEight {
    public static void main(String[] args){
        int i = 12344321;
        System.out.println(isPalindrome(i));
    }

    public static boolean isPalindrome(int number)
    {
        int reverse = 0;
        int originalNumber = number;
        while (number > 0)
        {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }

        return originalNumber == reverse;
    }
}
