public class WaitingForMoneyStateOfVendingMachine implements StateOfVendingMachine{
    @Override
    public void idle(VendingMachine vendingMachine) {
    }

    @Override
    public void waitingForMoney(VendingMachine vendingMachine) {
        Snack snack = vendingMachine.getSelectedSnack();
        System.out.println("Price: $" + snack.getPrice());
    }

    @Override
    public void dispensingSnack(VendingMachine vendingMachine) {
        Snack snack = vendingMachine.getSelectedSnack();
        double balance = vendingMachine.getBalance();

        if (snack.getPrice() > balance) {
            vendingMachine.setState(new WaitingForMoneyStateOfVendingMachine());
            System.out.println("Not enough money! Try again!");
        }
        else if (snack.getQuantity() <= 0) {
            vendingMachine.setState(new IdleStateOfVendingMachine());
            System.out.println("Not any '" + snack.getName() + "' left!");
        }
        else {
            vendingMachine.subtractBalance(snack.getPrice());
            System.out.println("Dispensing snack...");
            vendingMachine.setState(new DispensingSnackStateOfVendingMachine());
            vendingMachine.getState().idle(vendingMachine);
        }
    }
}
