import java.util.Arrays;

// Преобразовать массив так, чтобы сначала шли нулевые элементы, а затем все остальные.

public class TaskEight {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 5, 0, 10, 0, 6, 0, -1};
        int zeroEnd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }

            nums[i] = nums[zeroEnd];
            nums[zeroEnd] = 0;
            zeroEnd++;
        }

        System.out.println(Arrays.toString(nums));

    }
}
