public class TaskTen {
    public static void main(String[] args) {
        // Дано трехзначное целое число. Удалить в этом числе одну цифру так, чтобы осталось максимально возможное число. (порядок цифр не должен измениться)

        System.out.println("Task 10");
        int inputTen = 923;
        int resultTen = make(inputTen);
        System.out.println(resultTen);

    }

    public static int make(int number) {
        int maxNum = 0;
        for (int i = 0; i < 3; i++) {
            int current = deleteInt(number, i);
            if (current > maxNum){
                maxNum = current;
            }
        }
        return maxNum;
    }

    private static int deleteInt(int number, int i) {
        int left = (int) (number / Math.pow(10, i + 1));
        int right = number % (int) Math.pow(10, i);

        return (int) (left * Math.pow(10, i)) + right;
    }
}
