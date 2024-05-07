import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);

        Snack coke = new Snack("Coke", 2.0, 10);
        Snack pepsi = new Snack("Pepsi", 2.0, 5);
        Snack cheetos = new Snack("Cheetos", 1.5, 20);
        Snack doritos = new Snack("Doritos", 1.5, 25);
        Snack kitkat = new Snack("KitKat", 1.0, 5);
        Snack snickers = new Snack("Snickers", 1.0, 1);

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addSnack(snickers);
        vendingMachine.addSnack(kitkat);
        vendingMachine.addSnack(doritos);
        vendingMachine.addSnack(cheetos);
        vendingMachine.addSnack(pepsi);
        vendingMachine.addSnack(coke);


        System.out.println("Starting Driver!");

        System.out.println("Select snack: ");
        String input = scanner.nextLine();

        vendingMachine.selectSnack(input);
        System.out.println("Add money: ");
        input = scanner.nextLine();

        vendingMachine.insertMoney(Double.parseDouble(input));


        System.out.println("Select snack: ");
        input = scanner.nextLine();

        vendingMachine.selectSnack(input);
        System.out.println("Add money: ");
        input = scanner.nextLine();

        vendingMachine.insertMoney(Double.parseDouble(input));


        System.out.println("Select snack: ");
        input = scanner.nextLine();

        vendingMachine.selectSnack(input);
        System.out.println("Add money: ");
        input = scanner.nextLine();

        vendingMachine.insertMoney(Double.parseDouble(input));

    }
}