package numberlist.objectlist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the J-Unit test of the ComplexTest class
 *
 * @author Phuc Hong Le
 * @version 1 (02/01/2017)
 */
public class ComplexTest {

    //fields
    Complex c1;
    Complex c2;

    //default constructor of Test class
    public ComplexTest() {
    }

    /**
     * Setting up variables
     */
    @Before
    public void setUp() {
        c1 = new Complex(59.76, 41.52);
        c2 = new Complex(75.21, 8.57);
    }

    /**
     * Test of getReal method, of class Complex.
     */
    @Test
    public void testGetReal() {
        double expResult = 59.76;
        double incorrectResult = 25.36;
        double result = c1.getReal();
        assertEquals(expResult, result, 59.76);
        assertTrue(expResult == result);
        assertFalse(incorrectResult == result);
        System.out.println("getReal method PASSED!!!");
    }

    /**
     * Test of getImaginary method, of class Complex.
     */
    @Test
    public void testGetImaginary() {
        double expResult = 41.52;
        double incorrectResult = 25.36;
        double result = c1.getImaginary();
        assertEquals(expResult, result, 41.52);
        assertTrue(expResult == result);
        assertFalse(incorrectResult == result);
        System.out.println("getImaginary method PASSED!!!");
    }

    /**
     * Test of add method, of class Complex.
     */
    @Test
    public void testAdd() {
        Complex other = new Complex(1, 2);
        Complex expResult = new Complex(60.76, 43.52);
        Complex incResult = new Complex(5, 8);
        c1.add(other);
        Complex result = c1;
        assertTrue(expResult.getReal() == result.getReal());
        assertTrue(expResult.getImaginary() == result.getImaginary());
        assertFalse(incResult.getReal() == result.getReal());
        assertFalse(incResult.getImaginary() == result.getImaginary());
        System.out.println("add method PASSED!!!");
    }

    /**
     * Test of subtract method, of class Complex.
     */
    @Test
    public void testSubtract() {
        Complex other = new Complex(1, 2);
        Complex expResult = new Complex(74.21, 6.57);
        Complex incResult = new Complex(5, 8);
        c2.subtract(other);
        Complex result = c2;
        assertTrue(expResult.getReal() == result.getReal());
        assertTrue(expResult.getImaginary() == result.getImaginary());
        assertFalse(incResult.getReal() == result.getReal());
        assertFalse(incResult.getImaginary() == result.getImaginary());
        System.out.println("subtract method PASSED!!!");
    }

    /**
     * Test of toString method, of class Complex.
     */
    @Test
    public void testToString() {
        String result = "Here is the value of real = " + c1.getReal()
                + "\n Here is the value of imaginary = "
                + c1.getImaginary() + '}';
        assertEquals(c1.toString(), result);
        System.out.println("toString method PASSED!!!");
    }

    /**
     * Test of deepCopy method, of class Complex.
     */
    @Test
    public void testDeepCopy() {
        Complex expResult = c2;
        Complex incResult = c1;
        Complex result = c2.deepCopy();
        assertTrue(expResult.getReal() == result.getReal());
        assertTrue(expResult.getImaginary() == result.getImaginary());
        assertFalse(incResult.getReal() == result.getReal());
        assertFalse(incResult.getImaginary() == result.getImaginary());
        System.out.println("deepCopy method PASSED!!!");
    }

    /**
     * Test of compareTo method, of class Complex.
     */
    @Test
    public void testCompareTo() {
        Complex other = new Complex(59.76, 41.52);
        int expResult = 0;
        int result = c1.compareTo(other);
        int incResult = c2.compareTo(other);
        assertEquals(expResult, result);
        assertTrue(expResult == result);
        assertFalse(expResult == incResult);
        System.out.println("compareTo method PASSED!!!");
    }
}
