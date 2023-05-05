public class TaskNine {
    public static void main(String[] args){

        // Дано четырехзначное натуральное  число. Определить делится ли это число на все свои цифры.

        System.out.println("Task 9");
        int input = 1234;
        boolean result = canDivine(input);
        System.out.println(result);
    }

    public static boolean canDivine(int number){
        for (int i = 0; i < 5; i++) {
            if (!(number % getInt(number, i) == 0)){
                return false;
            }
        }
        return true;
    }

    private static int getInt(int number, int i){
        return (int) (number / Math.pow(10, i)) % 10;
    }
}
