// Найдите сумму элементов массива между двумя первыми нулями. Если двух нулей нет в массиве, то выведите ноль.

public class TaskFive {
    public static void main(String[] args) {

        int[] nums = new int[]{0, 4, 5, 6, 1234, 0};
        boolean passedZero = false;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                passedZero = !passedZero;
                if (!passedZero) {
                    break;
                }
            }

            if (passedZero) {
                sum += nums[i];
            }

        }

        if (passedZero) {
            sum = 0;
        }

        System.out.println(sum);

    }
}
