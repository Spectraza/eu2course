import java.util.Arrays;

//  Удалить в массиве все числа, которые повторяются более двух раз.

public class Main {
    public static void main(String[] args) {

        int[] numOne = new int[]{5, 6, 5, 4, 3, 5};
        boolean[] whatToKeep = new boolean[numOne.length];
        int newLength = 0;

        for (int i = 0; i < numOne.length; i++) {
            int count = 0;
            for (int j = 0; j < numOne.length; j++) {
                if (numOne[i] == numOne[j]) {
                    count++;
                }
            }

            if (!(count > 2)) {
                whatToKeep[i] = true;
                newLength++;
            }
        }

        int[] numTwo = new int[newLength];

        int j = 0;
        for (int i = 0; i < numOne.length; i++) {
            if (whatToKeep[i]) {
                numTwo[j] = numOne[i];
                j++;
            }
        }

        System.out.println(Arrays.toString(whatToKeep));
        System.out.println(Arrays.toString(numOne));
        System.out.println(Arrays.toString(numTwo));
    }
}