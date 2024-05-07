public class IdleStateOfVendingMachine implements StateOfVendingMachine {

    @Override
    public void idle(VendingMachine vendingMachine) {

    }

    @Override
    public void waitingForMoney(VendingMachine vendingMachine) {
        vendingMachine.setState(new WaitingForMoneyStateOfVendingMachine());
        Snack snack = vendingMachine.getSelectedSnack();
        System.out.println("Price: $" + snack.getPrice());
    }

    @Override
    public void dispensingSnack(VendingMachine vendingMachine) {
        System.out.println("Cannot dispense snack if not chosen");
    }
}
