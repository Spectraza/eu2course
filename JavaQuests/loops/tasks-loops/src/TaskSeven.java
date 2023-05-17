
//    7. Дано натуральное число n.
//    Удалить в этом числе все 3 и 8, оставив порядок цифр прежним.
//    Например, число 327082 преобразуется в 2702.

public class TaskSeven {

    public static void main(String[] args){
        int i = 123456789;
        int[] toDelete = new int[]{3, 8};
        System.out.println(delete(i, toDelete));
    }
    public static int delete(int n, int[] toDelete){
        for (int i = 0; n / (int) Math.pow(10, i) != 0; i++)
        {
            for (int x : toDelete)
            {
                if (checkAt(n, i, x))
                {
                    n = deleteAt(n, i);
                }
            }
        }

        return n;
    }

    private static int deleteAt(int n, int i)
    {
        return (n / (int) Math.pow(10, i + 1)) * (int) Math.pow(10, i) + n % (int) Math.pow(10, i);
    }

    private static boolean checkAt(int n, int i, int x)
    {
        int nx = (n / (int) Math.pow(10, i)) % 10;

        return nx == x;
    }
}
