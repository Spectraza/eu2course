import java.util.Scanner;

public class Actions {
    int choice;

    public void Show() {
        System.out.println("Select action");
        System.out.println("plus - 1");
        System.out.println("minus - 2");
        System.out.println("mut - 3");
        System.out.println("div - 4");
        System.out.println();
    }

    public int Getchoice() {
        System.out.println("choice");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        return choice;
    }

    public double Plus(int numone, int donnumone, int numtwo, int donnumtwo) {
        double tmpone = numone / (donnumone / 1.0);
        double tmptwo = numtwo / (donnumtwo / 1.0);
        double sum = tmpone + tmptwo;
        return sum;
    }

    public double Minus(float numone, float donnumone, float numtwo, float donnumtwo) {
        double tmpone = numone / (donnumone / 1.0);
        double tmptwo = numtwo / (donnumtwo / 1.0);
        double minus = tmpone - tmptwo;
        return minus;
    }

    public float Multi(float numone, float donnumone, float numtwo, float donnumtwo) {
        float tmpone = numone / donnumone;
        float tmptwo = numtwo / donnumtwo;
        float multi = tmpone * tmptwo;
        return multi;
    }

    public float Divi(float numone, float donnumone, float numtwo, float donnumtwo) {
        float tmpone = numone / donnumone;
        float tmptwo = numtwo / donnumtwo;
        float divi = tmpone / tmptwo;
        return divi;
    }
}
