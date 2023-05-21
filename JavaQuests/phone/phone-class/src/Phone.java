public class Phone {
    private String number;
    public String model;
    public double weight;

    public Phone() {
        this("N/A", "N/A", 0.0);
    }

    public Phone(String number, String model) {
        this(number, model, 0.0);
    }

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public void receiveCall(String callerName) {
        System.out.println(callerName + " is calling");
    }

    public void receiveCall(String callerName, String callerNumber) {
        System.out.println("Calls " + callerName + " with number " + callerNumber);
    }

    public String getNumber() {
        return number;
    }

    public void sendMessage(String... phoneNumbers) {
        System.out.println("Sending message to...");
        for (String number : phoneNumbers) {
            System.out.println(number);
        }
    }

}
