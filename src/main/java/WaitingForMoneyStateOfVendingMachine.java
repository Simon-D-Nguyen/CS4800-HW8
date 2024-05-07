public class WaitingForMoneyStateOfVendingMachine implements StateOfVendingMachine{
    @Override
    public void idle(VendingMachine vendingMachine) {

    }

    @Override
    public void waitingForMoney(VendingMachine vendingMachine) {

    }

    @Override
    public void dispensingSnack(VendingMachine vendingMachine) {
        vendingMachine.setState(new DispensingSnackStateOfVendingMachine());
        vendingMachine.dispenseSnack();

    }
}
