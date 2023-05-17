
// Необходимо вывести на экран таблицу умножения на 3 : 3*1=3 , 3*2=6, 3*3=9, 3*4=12, 3*5=15, 3*6=18, 3*7=21, 3*8=24 ,3*9=27, 3*10=30

public class TaskThree {
    public static void main(String[] args){

        int num = 3;
        int mult;
        for (int i = 1; i <= 10; i++) {
            mult = num * i;
            System.out.println(num + " * " + i + " = " + mult);
        }
    }
}
