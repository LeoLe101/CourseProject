package numberlist.primitivelist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the J-Unit test of the Floating Point Array List Test class
 *
 * @author Phuc Hong Le
 * @version 1 (02/01/2017)
 */
public class FloatingPointArrayListTest {
    
    //fields
    int index;
    int index1;
    int index2;
    int index3;
    int index4;
    double double1;
    double double2;
    FloatingPointArrayList instance;

    //default constructor of Test class
    public FloatingPointArrayListTest() {
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
        double1 = 89;
        double2 = 73;
        instance = new FloatingPointArrayList();
    }

    /**
     * Test of add method, of class NumberArrayList.
     */
    @Test
    public void testAdd() {
        instance.add(index1, double1);
        instance.add(index2, double2);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(instance.get(index1) == double1);
            assertTrue(instance.get(index2) == double2);
            assertFalse(instance.get(index3) == double2);
            assertFalse(instance.get(index4) == double2);
        }
        System.out.println("add method PASSED!!!");
    }

    /**
     * Test of removeAt method, of class NumberArrayList.
     */
    @Test
    public void testRemoveAt() {
        instance.add(index1, double1);
        instance.add(index2, double2);
        instance.removeAt(index2);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(instance.get(index1) == double1);
            assertTrue(instance.get(index2) == instance.get(index3));
            assertFalse(instance.get(index3) == double2);
            assertFalse(instance.get(index4) == double2);
        }
        System.out.println("removeAt method PASSED!!!");
    }

    /**
     * Test of remove method, of class NumberArrayList.
     */
    @Test
    public void testRemove() {
        instance.add(index1, double1);
        instance.add(index2, double2);
        instance.remove(double2);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(instance.get(index1) == double1);
            assertTrue(instance.get(index2) == instance.get(index3));
            assertFalse(instance.get(index3) == double2);
            assertFalse(instance.get(index4) == double2);
        }
        System.out.println("remove method PASSED!!!");
    }

    /**
     * Test of get method, of class NumberArrayList.
     */
    @Test
    public void testGet() {
        instance.add(index1, double1);
        instance.add(index2, double2);
        instance.get(index2);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(instance.get(index1) == double1);
            assertTrue(instance.get(index2) == double2);
            assertFalse(instance.get(index3) == double2);
            assertFalse(instance.get(index4) == double2);
        }
        System.out.println("get method PASSED!!!");
    }

    /**
     * Test of find method, of class NumberArrayList.
     */
    @Test
    public void testFind() {
        instance.add(index1, double1);
        instance.add(index2, double2);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(index1 == instance.find(double1));
            assertTrue(index2 == instance.find(double2));
            assertFalse(index3 == instance.find(double1));
            assertFalse(index4 == instance.find(double2));
        }
        System.out.println("find method PASSED!!!");
    }

    /**
     * Test of size method, of class NumberArrayList.
     */
    @Test
    public void testSize() {
        int sizeArray = 10;
        instance.add(index1, double1);
        instance.add(index2, double2);
        assertTrue(sizeArray == instance.size());
        assertFalse(sizeArray != instance.size());
        System.out.println("size method PASSED!!!");
    }

    /**
     * Test of toString method, of class NumberArrayList.
     */
    @Test
    public void testToString() {
        String testResult = "This is the list of Floating Point Array List";
        String result = instance.toString();
        assertTrue(testResult.equalsIgnoreCase(result));
        System.out.println("toString method PASSED!!!");
    }

}
