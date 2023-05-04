import java.util.Scanner;

public class Fraction {
    int donnum;
    int num;

    public Fraction() {

    }

    public int Getnum() {
        System.out.println("num");
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        return num;
    }

    public int Getdonnum() {
        System.out.println("donnum");
        Scanner scanner = new Scanner(System.in);
        donnum = scanner.nextInt();
        return donnum;
    }

    public void Equal() {
        System.out.println("num = " + num);
        System.out.println("donnum = " + donnum);
    }

}

