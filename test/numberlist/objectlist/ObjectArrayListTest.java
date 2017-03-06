package numberlist.objectlist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the J-Unit test of the ObjectArrayListTest class
 *
 * @author Phuc Hong Le
 * @version 1 (02/01/2017)
 */
public class ObjectArrayListTest {

    //fields
    int index;
    int index1;
    int index2;
    int index3;
    int index4;
    Object obj1;
    Object obj2;
    ObjectArrayList instance;
    
    //default constructor of Test class
    public ObjectArrayListTest() {
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
        obj1 = new Complex(5, 6);
        obj2 = new Complex(6, 9);
        instance = new ObjectArrayList();
    }

    /**
     * Test of add method, of class ObjectArrayList.
     */
    @Test
    public void testAdd() {
        instance.add(index1, obj1);
        instance.add(index2, obj2);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(instance.get(index1) == obj1);
            assertTrue(instance.get(index2) == obj2);
            assertFalse(instance.get(index3) == obj2);
            assertFalse(instance.get(index4) == obj2);
        }
        System.out.println("add method PASSED!!!");
    }

    /**
     * Test of removeAt method, of class ObjectArrayList.
     */
    @Test
    public void testRemoveAt() {
        instance.add(index1, obj1);
        instance.add(index2, obj2);
        instance.removeAt(index2);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(instance.get(index1) == obj1);
            assertTrue(instance.get(index2) == null);
            assertTrue(instance.get(index2) == instance.get(index3));
            assertFalse(instance.get(index2) == obj2);
            assertFalse(instance.get(index4) == obj2);
        }
        System.out.println("removeAt method PASSED!!!");
    }

    /**
     * Test of remove method, of class ObjectArrayList.
     */
    @Test
    public void testRemove() {
        instance.add(index1, obj1);
        instance.add(index2, obj2);
        instance.remove(obj2);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(instance.get(index1) == obj1);
            assertTrue(instance.get(index2) == null);
            assertFalse(instance.get(index2) == obj2);
            assertFalse(instance.get(index4) == obj2);
        }
        System.out.println("remove method PASSED!!!");
    }

    /**
     * Test of get method, of class ObjectArrayList.
     */
    @Test
    public void testGet() {
        instance.add(index1, obj1);
        instance.add(index2, obj2);
        instance.get(index2);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(instance.get(index1) == obj1);
            assertTrue(instance.get(index2) == obj2);
            assertFalse(instance.get(index3) == obj2);
            assertFalse(instance.get(index4) == obj2);
        }
        System.out.println("get method PASSED!!!");
    }

    /**
     * Test of find method, of class ObjectArrayList.
     */
    @Test
    public void testFind() {
        instance.add(index1, obj1);
        instance.add(index2, obj2);
        for (int i = 0; i < instance.size() - 1; i++) {
            assertTrue(index1 == instance.find(obj1));
            assertTrue(index2 == instance.find(obj2));
            assertFalse(index3 == instance.find(obj1));
            assertFalse(index4 == instance.find(obj2));
        }
        System.out.println("find method PASSED!!!");
    }

    /**
     * Test of size method, of class ObjectArrayList.
     */
    @Test
    public void testSize() {
        int sizeArray = 10;
        instance.add(index1, obj1);
        instance.add(index2, obj2);
        assertTrue(sizeArray == instance.size());
        assertFalse(sizeArray != instance.size());
        System.out.println("size method PASSED!!!");
    }

    /**
     * Test of toString method, of class ObjectArrayList.
     */
    @Test
    public void testToString() {
        String expResult = "This is the list of Object Array List";
        String result = instance.toString();
        assertEquals(expResult, result);
        System.out.println("toString method PASSED!!!");
    }

}
