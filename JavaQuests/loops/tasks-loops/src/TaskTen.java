
//  Дано натуральное число N.
//  Выяснить, сколько раз в этом числе встречается его максимальная цифра (за один просмотр числа).
//  Например в числе 673757 максимальная цифра 7 и встречается она  3 раза, а в числе 4935 максимальная цифра 9 и встречается она 1 раз.

public class TaskTen {
    public static void main(String[] args){
        int i = 1233999;
        System.out.println("Max number is " + TaskNine.findMaxDigit(i));
        System.out.println("We have this " + countMaxDigitOccurrences(i) + "times");
    }

    public static int countMaxDigitOccurrences(int number)
    {
        int maxDigit = TaskNine.findMaxDigit(number);
        int count = 0;

        while (number > 0)
        {
            int digit = number % 10;
            if (digit == maxDigit)
            {
                count++;
            }
            number = number / 10;
        }

        return count;
    }
}
