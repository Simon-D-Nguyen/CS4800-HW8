public class DispensingSnackStateOfVendingMachine implements StateOfVendingMachine{
    @Override
    public void idle(VendingMachine vendingMachine) {
        vendingMachine.setState(new IdleStateOfVendingMachine());
        System.out.println("Snack dispensed!");
    }

    @Override
    public void waitingForMoney(VendingMachine vendingMachine) {

    }

    @Override
    public void dispensingSnack(VendingMachine vendingMachine) {

    }
}
