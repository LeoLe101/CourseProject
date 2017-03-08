package numberlist.objectlist;

import numberlist.InvalidIndexException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the J-Unit test of the ObjectLinkedListTest class
 *
 * @author Phuc Hong Le
 * @version 1 (02/01/2017)
 */
public class ObjectLinkedListTest {

    //fields
    ObjectLinkedList instance;
    Node firstNode;
    Object obj;
    Object obj2;
    int index;
    int index1;
    int index2;
    int index3;
    int index4;

    //default constructor
    /**
     * default constructor
     */
    public ObjectLinkedListTest() {
    }

    /**
     * Setting up variables
     */
    @Before
    public void setUp() {
        index = 0;
        index1 = 0;
        index2 = 1;
        index3 = 2;
        index4 = 3;
        obj = new Complex(3, 4);
        obj2 = new Money(3L, (byte) 4);
        instance = new ObjectLinkedList();
        firstNode = new Node(obj);
    }

    /**
     * Test of add method, of class ObjectLinkedList.
     */
    @Test
    public void testAdd() 
            throws InvalidIndexException, UncopiableException{
        instance.add(index1, obj);
        instance.add(index2, obj2);
        assertTrue(instance.get(index1) == obj);
        assertTrue(instance.get(index2) == obj2);
        assertFalse(instance.get(index3) == obj2);
        assertFalse(instance.get(index4) == obj);
        System.out.println("add method PASSED!!!");
    }

    /**
     * Test of removeAt method, of class ObjectLinkedList.
     */
    @Test
    public void testRemoveAt() 
            throws InvalidIndexException, UncopiableException{
        instance.add(index1, obj);
        instance.add(index2, obj2);
        instance.add(index3, obj);
        instance.add(index4, obj2);
        instance.removeAt(index2);
        //the object is still at the index 2; however, it's Node has been passed by others
        assertTrue(instance.get(index1) == obj);
        assertTrue(instance.get(index2) == obj2);
        assertFalse(instance.get(index3) == obj);
        System.out.println("removeAt method PASSED!!!");
    }

    /**
     * Test of remove method, of class ObjectLinkedList.
     */
    @Test
    public void testRemove() 
            throws InvalidIndexException, UncopiableException{
        instance.add(index1, obj);
        instance.add(index2, obj2);
        instance.add(index3, obj);
        instance.add(index4, obj2);
        instance.remove(obj);
        //the object is still at index 1 and 3; however, it's Node has been passed by others
        assertTrue(instance.get(index1) == obj);
        assertTrue(instance.get(index3) == obj);
        assertFalse(instance.get(index4) == obj2);
        System.out.println("remove method PASSED!!!");
    }

    /**
     * Test of get method, of class ObjectLinkedList.
     */
    @Test
    public void testGet() 
            throws InvalidIndexException, UncopiableException{
        instance.add(index1, obj);
        instance.add(index2, obj2);
        assertTrue(instance.get(index1) == obj);
        assertTrue(instance.get(index2) == obj2);
        assertFalse(instance.get(index1) == obj2);
        assertFalse(instance.get(index2) == obj);
        System.out.println("get method PASSED!!!");
    }

    /**
     * Test of find method, of class ObjectLinkedList.
     */
    @Test
    public void testFind() 
            throws InvalidIndexException, UncopiableException{
        instance.add(index1, obj);
        instance.add(index2, obj2);
        assertTrue(index1 == instance.find(obj));
        assertTrue(index2 == instance.find(obj2));
        assertFalse(index3 == instance.find(obj2));
        assertFalse(index4 == instance.find(obj2));
        System.out.println("find method PASSSED!!!");
    }

    /**
     * Test of toString method, of class ObjectLinkedList.
     */
    @Test
    public void testToString() 
            throws InvalidIndexException, UncopiableException{
        instance.add(index1, obj);
        String expResult = "[ " + "5 + 6i" + " ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        System.out.println("toString method PASSED!!!");
    }

    /**
     * Test of deepCopy method, of class ObjectLinkedList.
     */
    @Test
    public void testDeepCopy() 
            throws InvalidIndexException, UncopiableException{
        instance.add(index1, obj);
        instance.add(index2, obj2);       
        assertTrue(instance == instance.deepCopy());
        assertTrue(instance != instance.deepCopy());
        System.out.println("deepCopy method PASSED!!!");
    }

}
