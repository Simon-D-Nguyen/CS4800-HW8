import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SnackDispenserTest {

    @Test
    public void testNoChainFail() {
        //Given
        SnackDispenseHandler handler = new SnackDispenser(null, new Snack("test", 1.0, 1));
        Snack expected = null;

        //When
        Snack actual = handler.handleRequest("");

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testNoChainSuccess() {
        //Given
        SnackDispenseHandler handler = new SnackDispenser(null, new Snack("test", 1.0, 1));
        Snack expected = null;

        //When
        Snack actual = handler.handleRequest("test");

        //Then
        assertNotEquals(expected, actual);
    }


    @Test
    public void testFrontOfChainHandleRequest() {
        //Given
        Snack expected = new Snack("expected", 0, 1);
        SnackDispenseHandler handler = new SnackDispenser(null, new Snack("test", 1.0, 1));
        handler = new SnackDispenser(handler, expected);


        //When
        Snack actual = handler.handleRequest("expected");

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testBackOfChainHandleRequest() {
        //Given
        Snack expected = new Snack("expected", 0, 1);
        SnackDispenseHandler handler = new SnackDispenser(null, expected);
        handler = new SnackDispenser(handler, new Snack("test", 1.0, 1));

        //When
        Snack actual = handler.handleRequest("expected");

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testNoRemainingHandleRequest() {
        //Given
        Snack expected = new Snack("expected", 0, 0);
        SnackDispenseHandler handler = new SnackDispenser(null, expected);
        handler = new SnackDispenser(handler, new Snack("test", 1.0, 1));

        //When
        Snack actual = handler.handleRequest("expected");

        //Then
        assertNotEquals(expected, actual);
    }
}
