public class DispensingSnackStateOfVendingMachine implements StateOfVendingMachine{
    @Override
    public void idle(VendingMachine vendingMachine) {
        SnackDispenseHandler handler = vendingMachine.getSnackHandler();
        Snack selectedSnack = vendingMachine.getSelectedSnack();

        vendingMachine.setState(new IdleStateOfVendingMachine());
        handler.handleRequest(selectedSnack.getName());
        System.out.println("Snack dispensed!");
    }

    @Override
    public void waitingForMoney(VendingMachine vendingMachine) {

    }

    @Override
    public void dispensingSnack(VendingMachine vendingMachine) {

    }
}
