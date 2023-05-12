
// Найдите сумму номеров минимального и максимального элементов.

public class TaskNine {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 4, 5, 9};
        int maxI = 0;
        int minI = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxI]) {
                maxI = i;
            }
            if (nums[i] < nums[minI]) {
                minI = i;
            }
        }

        System.out.println(maxI + minI);

    }
}
