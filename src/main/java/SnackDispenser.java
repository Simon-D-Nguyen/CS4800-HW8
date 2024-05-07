public class SnackDispenser extends SnackDispenseHandler{
    private Snack snack;


    private boolean snackIsAvailable(String snackType) {
        return snackType.equals(snack.getName()) && snack.getQuantity() > 0;
    }


    public SnackDispenser(SnackDispenseHandler next, Snack snack){
        super(next);
        this.snack = snack;
    }


    public Snack handleRequest(String snackType){
        if (snackIsAvailable(snackType)) {
            snack.decrementQuantity();
            System.out.println("Dispensing: '"+ snackType + "'");
            System.out.println("--- Remaining: " + snack.getQuantity());
            return snack;
        }
        else if (snack.getQuantity() <= 0){
            System.out.println("Out of \'" + snack.getName() + "\'!!!");
            return null;
        }
        else {
            System.out.println("Not \'"+ snack.getName() + "\'...");
            return super.handleRequest(snackType);
        }
    }

}
