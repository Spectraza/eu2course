
//  Найдите сумму отрицательных элементов массива.

public class TaskThree {
    public static void main(String[] args){
        int[] nums = new int[]{-3, -4, 5, 6, 3};
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0){
                sum += nums[i];
            }
        }
        System.out.println(sum);
    }
}
