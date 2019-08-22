package maxmin;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {
    Finder maxmin = new Finder();
    int[] a = { 1, 6, 7, 8, 9, -2, 5 };
    int[] b = {};
    int[] c = null;

    /**
     * testing validity
     */
    @Test
    public void maxTestValid() {
        int expected = 9;
        int actual = maxmin.findMax(a);
        assertEquals(expected, actual);
    }

    /**
     * testing for empty array
     */
    @Test(expected = IllegalArgumentException.class)
    public void maxTestEmpty() {
        maxmin.findMax(b);
    }

    /**
     * testing for null
     */
    @Test(expected = NullPointerException.class)
    public void maxTestNull() {
        maxmin.findMax(c);
    }

    /**
     * testing validity
     */
    @Test
    public void minTestValid() {
        int expected = -2;
        int actual = maxmin.findMin(a);
        assertEquals(expected, actual);
    }

    /**
     * testing for empty array
     */
    @Test(expected = IllegalArgumentException.class)
    public void minTestEmpty() {
        maxmin.findMin(b);
    }

    /**
     * testing for null
     */
    @Test(expected = NullPointerException.class)
    public void minTestNull() {
        maxmin.findMin(c);
    }
}
