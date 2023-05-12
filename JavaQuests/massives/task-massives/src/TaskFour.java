
// Найдите произведение элементов массива с нечетными номерами.

public class TaskFour {
    public static void main(String[] args) {

        int[] nums = new int[]{3, 5, 6, 4, 7, 2};
        int multi = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                multi *= nums[i];
            }
        }

        System.out.println(multi);

    }
}
