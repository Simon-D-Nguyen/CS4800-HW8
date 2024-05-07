import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private StateOfVendingMachine state;
    private SnackDispenseHandler snackHandler;
    private Map<String, Snack> snacks;
    private Snack selectedSnack;


    public VendingMachine(){
        this.state = new IdleStateOfVendingMachine();
        this.snacks = new HashMap<>();
        this.snackHandler = new SnackDispenser(null, null);
        this.selectedSnack = null;
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
            System.out.println("Amount entered: $" + amount);
            this.getState().dispensingSnack(this);

            return 10.0;
        }
    }


    public Snack dispenseSnack() {
        getState().idle(this);
        return snackHandler.handleRequest(selectedSnack.getName());
    }

}
