import java.util.Arrays;

// Введите одномерный целочисленный массив. Найдите наибольший нечетный элемент.
// Далее трижды осуществите циклический сдвиг влево элементов, стоящих справа от
// найденного максимума, и один раз сдвиг элементов вправо, стоящих слева от найденного максимума.

public class TaskTwo {
    public static void main(String[] args) {
        int[] num = new int[]{5, 6, 3, 7, 2, 1};
        int greatestOdd = 0;

        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 1 && num[i] > num[greatestOdd]) {
                greatestOdd = i;
            }
        }

        for (int i = 0; i < num.length; i++) {
            if (i < greatestOdd) {
                num[i] >>= 1;
            }
            if (i > greatestOdd) {
                num[i] <<= 3;
            }
        }

        System.out.println(Arrays.toString(num));
    }
}
