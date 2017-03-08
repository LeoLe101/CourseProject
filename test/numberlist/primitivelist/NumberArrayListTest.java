package numberlist.primitivelist;

import numberlist.InvalidIndexException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the J-Unit test of the Number Array List Test class
 *
 * @author Phuc Hong Le
 * @version 1 (02/01/2017)
 */
public class NumberArrayListTest {

    //fields
    int index;
    int index1;
    int index2;
    int index3;
    int index4;
    long long1;
    long long2;
    NumberArrayList instance;

    //default constructor of Test class
    /**
     * default constructor
     */
    public NumberArrayListTest() {
    }

    /**
     * Setting up data for the J-Unit test
     */
    @Before
    public void setUp() {
        index = 0;
        index1 = 0;
        index2 = 1;
        index3 = 4;
        index4 = 9;
        long1 = 9L;
        long2 = 7L;
        instance = new NumberArrayList();
    }

    /**
     * Test of add method, of class NumberArrayList.
     */
    @Test
    public void testAdd()
            throws InvalidIndexException {
        instance.add(index1, long1);
        instance.add(index2, long2);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(instance.get(index1) == long1);
            assertTrue(instance.get(index2) == long2);
            assertFalse(instance.get(index3) == long2);
            assertFalse(instance.get(index4) == long2);
        }
        System.out.println("add method PASSED!!!");
    }

    /**
     * Test of removeAt method, of class NumberArrayList.
     */
    @Test
    public void testRemoveAt()
            throws InvalidIndexException {
        instance.add(index1, long1);
        instance.add(index2, long2);
        instance.removeAt(index2);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(instance.get(index1) == long1);
            assertTrue(instance.get(index2) == instance.get(index3));
            assertFalse(instance.get(index3) == long2);
            assertFalse(instance.get(index4) == long2);
        }
        System.out.println("removeAt method PASSED!!!");
    }

    /**
     * Test of remove method, of class NumberArrayList.
     */
    @Test
    public void testRemove()
            throws InvalidIndexException {
        instance.add(index1, long1);
        instance.add(index2, long2);
        instance.remove(long2);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(instance.get(index1) == long1);
            assertTrue(instance.get(index2) == instance.get(index3));
            assertFalse(instance.get(index3) == long2);
            assertFalse(instance.get(index4) == long2);
        }
        System.out.println("remove method PASSED!!!");
    }

    /**
     * Test of get method, of class NumberArrayList.
     */
    @Test
    public void testGet()
            throws InvalidIndexException {
        instance.add(index1, long1);
        instance.add(index2, long2);
        instance.get(index2);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(instance.get(index1) == long1);
            assertTrue(instance.get(index2) == long2);
            assertFalse(instance.get(index3) == long2);
            assertFalse(instance.get(index4) == long2);
        }
        System.out.println("get method PASSED!!!");
    }

    /**
     * Test of find method, of class NumberArrayList.
     */
    @Test
    public void testFind()
            throws InvalidIndexException {
        instance.add(index1, long1);
        instance.add(index2, long2);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(index1 == instance.find(long1));
            assertTrue(index2 == instance.find(long2));
            assertFalse(index3 == instance.find(long1));
            assertFalse(index4 == instance.find(long2));
        }
        System.out.println("find method PASSED!!!");
    }

    /**
     * Test of size method, of class NumberArrayList.
     */
    @Test
    public void testSize()
            throws InvalidIndexException {
        int sizeArray = 10;
        instance.add(index1, long1);
        instance.add(index2, long2);
        assertTrue(sizeArray == instance.size());
        assertFalse(sizeArray != instance.size());
        System.out.println("size method PASSED!!!");
    }

    /**
     * Test of toString method, of class NumberArrayList.
     */
    @Test
    public void testToString()
            throws InvalidIndexException {
        instance.add(index1, long1);
        String testResult = "[ " + "9" + " ]";
        String result = instance.toString();
        assertTrue(testResult.equalsIgnoreCase(result));
        System.out.println("toString method PASSED!!!");
    }

}
