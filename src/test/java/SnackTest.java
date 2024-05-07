import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SnackTest {

    @Test
    public void testGetName() {
        //Given
        Snack tester = new Snack("test", 10, 1);
        String expected = "test";

        //When
        String actual = tester.getName();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testGetPrice() {
        //Given
        Snack tester = new Snack("test", 10, 1);
        double expected = 10.0;

        //When
        double actual = tester.getPrice();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testGetQuantity() {
        //Given
        Snack tester = new Snack("test", 10, 1);
        int expected = 1;

        //When
        int actual = tester.getQuantity();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testDecrementQuantity(){
        //Given
        Snack tester = new Snack("", 10, 1);
        int expected = 0;

        //When
        tester.decrementQuantity();
        int actual = tester.getQuantity();

        //Then
        assertEquals(expected, actual);
    }
}
