import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private StateOfVendingMachine state;
    private SnackDispenseHandler snackHandler;
    private Map<String, Snack> snacks;
    private Snack selectedSnack;
    private double balance;


    public VendingMachine(){
        this.state = new IdleStateOfVendingMachine();
        this.snacks = new HashMap<>();
        this.snackHandler = new SnackDispenser(null, null);
        this.selectedSnack = null;
        balance = 0.0;
    }


    public void setState(StateOfVendingMachine state){
        this.state = state;
    }


    public StateOfVendingMachine getState(){
        return state;
    }


    public void addSnack(Snack snack) {
        snacks.put(snack.getName(), snack);
        snackHandler = new SnackDispenser(snackHandler, snack);
    }


    public Snack getSelectedSnack() {
        return selectedSnack;
    }


    public SnackDispenseHandler getSnackHandler() {
        return snackHandler;
    }


    public double getBalance() {
        return balance;
    }


    public double subtractBalance(double cost) {
        balance = balance - cost;
        return balance;
    }


    public void selectSnack(String name){
        if (snacks.containsKey(name))
        {
            selectedSnack = snacks.get(name);
            this.getState().waitingForMoney(this);
        }
        else {
            this.getState().idle(this);
        }

    }


    public double insertMoney(double amount) {
        if(selectedSnack == null) {
            System.out.println("Must select snack first!");
            return amount;
        }
        else {
            balance = amount;
            System.out.println("Amount entered: $" + amount);
            System.out.println("Current Balance: $" + balance);
            this.getState().dispensingSnack(this);

            System.out.println("---> Returned: $" + balance);
            return balance;
        }
    }
}
