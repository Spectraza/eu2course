
// Дано натуральное число N. Найти максимальную цифру в этом числе

public class TaskNine {
    public static void main(String[] args){
        int i = 111911;
        System.out.println(findMaxDigit(i));
    }

    public static int findMaxDigit(int number)
    {
        int maxDigit = 0;

        while (number > 0)
        {
            int digit = number % 10;
            if (digit > maxDigit)
            {
                maxDigit = digit;
            }
            number = number / 10;
        }

        return maxDigit;
    }
}
