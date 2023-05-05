public class TaskTwo {
    public static void main(String[] args) {

        //      Дано пятизначное натуральное число. Узнать, есть ли в записи числа одинаковые цифры.

        System.out.println("Task 2");

        int num = 12345;

        boolean arePairs = false;

        for (int i = 0; i < 5; i++) {
            int current = getInt(num, i);
            int counter = 0;

            for (int j = 0; j < 5; j++) {
                int currentJ = getInt(num, j);
                if (current == currentJ) {
                    counter++;
                }
            }
            if (counter > 1) {
                arePairs = true;
                break;
            }
        }

        if (arePairs) {
            System.out.println(arePairs);
        } else {
            System.out.println("We didn't find any pairs");
        }
    }

    private static int getInt(int number, int i) {
        return (int) (number / Math.pow(10, i)) % 10;
    }
}
