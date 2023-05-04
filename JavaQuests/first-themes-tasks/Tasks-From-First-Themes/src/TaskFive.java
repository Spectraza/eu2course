public class TaskFive {
    public static void main(String[] args) {

        //Дано четырехзначное натуральное  число. Определить имеется ли в записи числа цифра 3.

        System.out.println("Task 5");
        int n = 1000;
        int n1 = n;
        int count = 0;
        while (n1 > 0) {
            int b = n1 % 10;
            if (b == 3) {
                count++;
            }
            n1 /= 10;
        }
        System.out.println("All numbers 3 is " + count);
    }
}
