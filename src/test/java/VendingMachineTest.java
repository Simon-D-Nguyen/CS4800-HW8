import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class VendingMachineTest {

    @Test
    public void testSelectedSnack() {
        //Given
        VendingMachine vm = new VendingMachine();
        Snack expected = new Snack("expected", 1, 2);
        vm.addSnack(expected);

        //When
        vm.selectSnack("expected");
        Snack actual = vm.getSelectedSnack();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testSubtractBalance() {
        //Given
        VendingMachine vm = new VendingMachine();
        double expected = -1;

        //When
        double actual = vm.subtractBalance(1);

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testPerfectBalanceInsertMoney() {
        //Given
        VendingMachine vm = new VendingMachine();
        Snack snack = new Snack("test", 1.1, 1);
        vm.addSnack(snack);
        vm.selectSnack("test");
        double expected = 0;

        //When
        double actual = vm.insertMoney(1.1);

        //Then
        assertEquals(expected, actual);

    }


    @Test
    public void testTooLowBalanceInsertMoney() {
        //Given
        VendingMachine vm = new VendingMachine();
        Snack snack = new Snack("test", 1.1, 1);
        vm.addSnack(snack);
        vm.selectSnack("test");
        double expected =  1;

        //When
        double actual = vm.insertMoney(1);

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testTooHighBalanceInsertMoney() {
        //Given
        VendingMachine vm = new VendingMachine();
        Snack snack = new Snack("test", 1.1, 1);
        vm.addSnack(snack);
        vm.selectSnack("test");
        double expected =  1;

        //When
        double actual = vm.insertMoney(2.1);

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testEmptyAccess() {
        //Given
        VendingMachine vm = new VendingMachine();
        Snack expected = null;

        //When
        vm.selectSnack("");
        Snack actual = vm.getSelectedSnack();

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void testIncorrectSnack() {
        //Given
        VendingMachine vm = new VendingMachine();
        Snack snack = new Snack("test", 1.1, 1);
        vm.addSnack(snack);
        Snack expected = null;

        //When
        vm.selectSnack("");
        Snack actual = vm.getSelectedSnack();

        //Then
        assertEquals(expected, actual);
    }


}
