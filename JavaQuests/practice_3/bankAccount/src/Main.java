public class Main {
    public static void main(String[] args) {
        Bankacc bacc = new Bankacc();
        bacc.name = "Mark";
        bacc.numberacc = 2354567;
        bacc.money = 30000;
        bacc.percent = 20;
        bacc.ShowValues();
        bacc.Setname("Varus");
        bacc.ShowValues();
        bacc.Setsumpersent(bacc.money, bacc.percent);
        bacc.ShowValues();

        Bankacc bacc1 = new Bankacc("Oleg", 111125, 15,20000);

        bacc1.ShowValues();
    }
}