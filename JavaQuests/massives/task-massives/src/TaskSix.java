
// Найдите наибольший элемент массива.

public class TaskSix {
    public static void main(String[] args) {

        int[] nums = new int[]{4, 5, 6, 2, 3};
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        System.out.println(max);

    }
}
