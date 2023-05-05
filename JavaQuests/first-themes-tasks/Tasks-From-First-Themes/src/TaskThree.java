public class TaskThree {
    public static void main(String[] args) {

        // Дано четырехзначное натуральное  число. Определить содержит, ли число ровно три одинаковые цифры.

        System.out.println("Task 3");
        int inputThree = 2224;
        boolean resultThree = hasThreeSame(inputThree);
        System.out.println(resultThree);

    }

    public static boolean hasThreeSame(int number) {
        for (int i = 0; i < 5; i++) {
            if (checkInt(number, (int) (number / Math.pow(10, i)) % 10)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkInt(int number, int a) {
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            if ((int) (number / Math.pow(10, i)) % 10 == a) {
                counter++;
            }
        }
        return counter == 3;
    }
}
