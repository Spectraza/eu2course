public class TaskEight {
    public static void main(String[] args) {

        // Дано четырехзначное натуральное  число. Определить, кратна ли сумма цифр числам 2 и 3.

        System.out.println("Task 8");
        int input = 1234;
        boolean result = isCrat(input);
        System.out.println(result);

    }

    public static boolean isCrat(int number) {
        return getSum(number) % 2 == 0 && getSum(number) % 3 == 0;
    }

    private static int getSum(int number) {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += (int) (number / Math.pow(10, i)) % 10;
        }
        return sum;
    }
}
