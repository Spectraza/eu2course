public class TaskSix {
    public static void main(String[] args){

        // Дано четырехзначное натуральное  число. Определить имеется ли в  числе подряд идущие цифры 3,  7.

        System.out.println("Task 6");
        int input = 1234;
        boolean result = hasInRow(input);
        System.out.println(result);
    }

    public static boolean hasInRow(int number){
        for (int i = 0; i < 5; i++) {
            if ((int) (number / Math.pow(10, i)) % 10 == 3) {
                if ((int) (number / Math.pow(10, i + 1)) % 10 == 7) {
                    return true;
                }
            }
        }
        return false;
    }
}
