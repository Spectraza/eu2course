
// Найдите наименьший четный элемент массива. Если такого нет, то выведите первый элемент.

public class TaskSeven {
    public static void main(String[] args){
        int[] nums = new int[]{4, 5, 6, 2, 3};
        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0 && nums[i] < min){
                min = nums[i];
            }
        }

        System.out.println(min);

    }
}
