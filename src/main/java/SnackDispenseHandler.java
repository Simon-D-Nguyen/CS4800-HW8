public abstract class SnackDispenseHandler {
    private SnackDispenseHandler next;


    public SnackDispenseHandler(SnackDispenseHandler next){
        this.next = next;
    }


    public Snack handleRequest(String snackType){
        if (snackType != null && next != null) {
            return next.handleRequest(snackType);
        }

        System.out.println("No snack found!");
        return null;
    }
}
