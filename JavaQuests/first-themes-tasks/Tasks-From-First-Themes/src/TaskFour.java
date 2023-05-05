public class TaskFour {
    public static void main(String[] args) {

        //Дано четырехзначное натуральное  число. Определить все ли цифры числа различны.

        System.out.println("Task 4");
        int input = 12345;
        boolean result = areDifferent(input);
        System.out.println(result);
    }

    public static boolean areDifferent(int number) {
        for (int i = 0; i < 5; i++) {
            if (!checkInt(number, (int) (number / Math.pow(10, i)) % 10)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkInt(int number, int a) {
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            if ((int) (number / Math.pow(10, i)) % 10 == a) {
                counter++;
            }
        }
        return counter == 1;
    }
}
