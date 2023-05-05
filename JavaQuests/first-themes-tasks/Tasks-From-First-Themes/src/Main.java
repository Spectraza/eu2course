public class Main {
    public static void main(String[] args) {

        //        Дано пятизначное натуральное число. Определить является, ли это число палиндромом.

        System.out.println("Task 1");
        int number = 33333;
        int n = 0;
        int utNum = number;

        while (utNum != 0) {
            n++;
            utNum /= 10;
        }

        boolean isPolindrome = true;

        for (int i = 0; i <= n; i++) {
            int a = (int) (number / Math.pow(10, i)) % 10;
            int b = (int) (number / Math.pow(10, n - 1 - i)) % 10;

            if (a != b) {
                isPolindrome = false;
                break;
            }

        }

        if (isPolindrome) {
            System.out.println("Polimdrome");
        } else {
            System.out.println("Not Polindrome");
        }
    }
}