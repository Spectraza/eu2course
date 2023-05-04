public class Bankacc {
    String name;
    int numberacc;
    int percent;
    int money;

    public Bankacc() {

    }

    public Bankacc(String name, int numberacc, int percent, int money) {
        this.name = name;
        this.numberacc = numberacc;
        this.percent = percent;
        this.money = money;
    }

    public int Setsumpersent(int money, int percent){
        this.money += money*(percent/100.0);
        return money;
    }

    public String Setname(String name){
        this.name = name;
        return this.name;
    }

    public void ShowValues (){
        System.out.println(name+"/n");
        System.out.println(numberacc+"/n");
        System.out.println(percent+"/n");
        System.out.println(money+"/n");
    }
}
