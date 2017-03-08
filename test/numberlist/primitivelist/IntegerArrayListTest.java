package numberlist.primitivelist;

import numberlist.InvalidIndexException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the J-Unit test of the Integer Array List Test class
 *
 * @author Phuc Hong Le
 * @version 1 (02/05/2017)
 */
public class IntegerArrayListTest {

    //fields
    IntegerArrayList instance;
    long value;
    long falseValue;

    //default constructor of Test class
    /**
     * default constructor
     */
    public IntegerArrayListTest() {
    }

    /**
     * Setting up data for the J-Unit test
     */
    @Before
    public void setUp()
            throws InvalidIndexException {
        value = 25;
        falseValue = 12;
        instance = new IntegerArrayList();
        instance.add(0, falseValue);
        instance.add(1, falseValue);
        instance.add(2, value);
        instance.add(3, falseValue);
        instance.add(4, value);
        instance.add(5, falseValue);
        instance.add(6, falseValue);
        instance.add(7, falseValue);
        instance.add(8, falseValue);
        instance.add(9, falseValue);
    }

    /**
     * Test of add method, of class RealArrayList.
     */
    @Test
    public void testAdd()
            throws InvalidIndexException {
        instance.add(value);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(instance.get(9) == value);
            assertFalse(instance.get(instance.size() - 1) == value);
        }
        System.out.println("add method PASSED!!!");
    }

    /**
     * Test of findLast method, of class RealArrayList.
     */
    @Test
    public void testFindLast()
            throws InvalidIndexException {
        int expResult = 4;
        int falsResult = 2;
        int result = instance.findLast(value);
        assertTrue(expResult == result);
        assertFalse(falsResult == result);
        System.out.println("findLast method PASSED!!!");
    }
}
