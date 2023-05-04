import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        дії з дробами, 2 класи, опишепо класи в яких ми будемо визивати функцію, виводити
        Fraction f = new Fraction();
        Fraction d = new Fraction();
        Actions p = new Actions();
        boolean ask = true;
        double result = 0;

        do {
            p.Show();
            switch (p.Getchoice()) {
                case 1:
                    result = p.Plus(f.Getnum(), f.Getdonnum(), d.Getnum(), d.Getdonnum());
                    System.out.println(result);
                    break;
                case 2:
                    result = p.Minus(f.Getnum(), f.Getdonnum(), d.Getnum(), d.Getdonnum());
                    System.out.println(result);
                    break;
                case 3:
                    result = p.Multi(f.Getnum(), f.Getdonnum(), d.Getnum(), d.Getdonnum());
                    System.out.println(result);
                    break;
                case 4:
                    result = p.Divi(f.Getnum(), f.Getdonnum(), d.Getnum(), d.Getdonnum());
                    System.out.println(result);
                default:
                    System.out.println("We don't have this type of action");
                    break;
            }
            System.out.println("Do you want to continue?");
            Scanner c = new Scanner(System.in);
            ask = c.nextBoolean();
        }

        while (ask == true);

//        double result = p.Plus(f.Getnum(), f.Getdonnum(), d.Getnum(), d.Getdonnum());
//        System.out.println(result);
    }
}