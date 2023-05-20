
// Дано действительное число а и целое число n>0. Вычислить a^n

public class TaskTwelve {

    public static void main(String[] args){
        System.out.println(pow(5, 3));
    }
    public static int pow(int a, int n)
    {
        int pow = 1;
        for (int i = 0; i < n; i++)
        {
            pow *= a;
        }

        return pow;
    }
}
