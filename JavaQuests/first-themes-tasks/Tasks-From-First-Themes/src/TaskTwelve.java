public class TaskTwelve {
    public static void main(String[] args){

        // Даны два целых числа. Поменять местами их значения.

        System.out.println("Task 12");
        int num1 = 2;
        int num2 = 3;

        System.out.println(num1);
        System.out.println(num2);

        int temp = num2;
        num2 = num1;
        num1 = temp;

        System.out.println(num1);
        System.out.println(num2);
    }
}
