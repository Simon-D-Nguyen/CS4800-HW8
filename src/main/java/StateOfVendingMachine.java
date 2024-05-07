public interface StateOfVendingMachine {
    public void idle(VendingMachine vendingMachine);
    public void waitingForMoney(VendingMachine vendingMachine);
    public void dispensingSnack(VendingMachine vendingMachine);
}
