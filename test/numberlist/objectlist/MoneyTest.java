package numberlist.objectlist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the J-Unit test of the MoneyTest class
 *
 * @author Phuc Hong Le
 * @version 1 (02/01/2017)
 */
public class MoneyTest {

    //fields
    Money c1;
    Money c2;

    //default constructor of Test class
    public MoneyTest() {
    }

    /**
     * Setting up variables
     */
    @Before
    public void setUp() {
        c1 = new Money(59L, (byte) 52);
        c2 = new Money(75L, (byte) 57);
    }

    /**
     * Test of getDollars method, of class Money.
     */
    @Test
    public void testGetDollars() {
        long expResult = 59L;
        long incorrectResult = 25L;
        long result = c1.getDollars();
        assertEquals(expResult, result, 59L);
        assertTrue(expResult == result);
        assertTrue(incorrectResult == result);
        System.out.println("getDollars method PASSED!!!");
    }

    /**
     * Test of getCents method, of class Money.
     */
    @Test
    public void testGetCents() {
        byte expResult = (byte) 52;
        byte incorrectResult = (byte) 25;
        byte result = c1.getCents();
        assertEquals(expResult, result, (byte) 52);
        assertTrue(expResult == result);
        assertFalse(incorrectResult == result);
        System.out.println("getCents method PASSED!!!");
    }

    /**
     * Test of add method, of class Money.
     */
    @Test
    public void testAdd() {
        Money other = new Money(1L, (byte) 2);
        Money expResult = new Money(60L, (byte) 54);
        Money incResult = new Money(5L, (byte) 8);
        c1.add(other);
        Money result = c1;
        assertTrue(expResult.getDollars() == result.getDollars());
        assertTrue(expResult.getCents() == result.getCents());
        assertFalse(incResult.getDollars() == result.getDollars());
        assertFalse(incResult.getCents() == result.getCents());
        System.out.println("add method PASSED!!!");
    }

    /**
     * Test of subtract method, of class Money.
     */
    @Test
    public void testSubtract() {
        Money other = new Money(1L, (byte) 2);
        Money expResult = new Money(58L, (byte) 50);
        Money incResult = new Money(5L, (byte) 8);
        c1.subtract(other);
        Money result = c1;
        assertTrue(expResult.getDollars() == result.getDollars());
        assertTrue(expResult.getCents() == result.getCents());
        assertFalse(incResult.getDollars() == result.getDollars());
        assertFalse(incResult.getCents() == result.getCents());
        System.out.println("subtract method PASSED!!!");
    }

    /**
     * Test of toString method, of class Money.
     */
    @Test
    public void testToString() {
        String result = "$" + c1.getDollars() + "." + c1.getCents();
        assertEquals(c1.toString(), result);
        System.out.println("toString method PASSED!!!");
    }

    /**
     * Test of deepCopy method, of class Money.
     */
    @Test
    public void testDeepCopy() {
        Money expResult = c2;
        Money incResult = c1;
        Money result = c2.deepCopy();
        assertTrue(expResult.getDollars() == result.getDollars());
        assertTrue(expResult.getCents() == result.getCents());
        assertFalse(incResult.getDollars() == result.getDollars());
        assertFalse(incResult.getCents() == result.getCents());
        System.out.println("deepCopy method PASSED!!!");
    }

    /**
     * Test of compareTo method, of class Money.
     */
    @Test
    public void testCompareTo() {
        Money other = new Money(59L, (byte)52);
        int expResult = 0;
        int result = c1.compareTo(other);
        int incResult = c2.compareTo(other);
        assertEquals(expResult, result);
        assertTrue(expResult == result);
        assertFalse(expResult == incResult);
        System.out.println("compareTo method PASSED!!!");
    }
}
