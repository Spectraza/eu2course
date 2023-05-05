public class TaskEleven {
    public static void main(String[] args){

        // Дано пятизначное натуральное число. Удалить в этом числе 2 цифры, чтобы осталось максимально возможное число. (порядок цифр не должен измениться)

        System.out.println("Task 11");
        int inputEleven = 12345;
        int resultEleven = getMax(inputEleven);
        System.out.println(resultEleven);

    }

    public static int getMax(int number){
        int max = 0;
        for (int i = 0; i < 5; i++) {
            int currentI = deleteInt(number ,i);
            for (int j = 0; j < 4; j++) {
                int currentJ = deleteInt(currentI, j);
                if (currentJ > max){
                    max = currentJ;
                }
            }
        }
        return max;
    }

    private static int deleteInt(int number, int i) {
        int left = (int) (number / Math.pow(10, i + 1));
        int right = number % (int) Math.pow(10, i);

        return (int) (left * Math.pow(10, i)) + right;
    }
}
