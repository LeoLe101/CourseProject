package numberlist.objectlist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the J-Unit test of the NodeTest class
 *
 * @author Phuc Hong Le
 * @version 1 (02/01/2017)
 */
public class NodeTest {

    //field 
    Node instance;
    Node next;
    Object obj = new Object();

    /**
     * default constructor
     */
    public NodeTest() {
    }

    /**
     * Setting up variables
     */
    @Before
    public void setUp() {
        instance = new Node(obj);
        next = new Node(obj);
    }

    /**
     * Test of getValue method, of class Node.
     */
    @Test
    public void testGetValue() {
        Complex obj1 = new Complex(1, 2);
        Object incObj = new Complex(12, 24);
        instance = new Node(obj1);
        Object expResult = obj1;
        Object result = instance.getValue();
        assertTrue(instance.getValue() == obj1);
        assertFalse(instance.getValue() == incObj);
        System.out.println("getValue method PASSED!!!");
    }

    /**
     * Test of setValue method, of class Node.
     */
    @Test
    public void testSetValue() {
        Complex obj1 = new Complex(1, 2);
        Object incObj = new Complex(12, 24);
        instance.setValue(obj1);
        assertTrue(instance.getValue() == obj1);
        assertFalse(instance.getValue() == incObj);
        System.out.println("setValue method PASSED!!!");
    }

    /**
     * Test of getNext method, of class Node.
     */
    @Test
    public void testGetNext() {
        Node expResult = next.getNext();
        Node result = instance.getNext();
        assertTrue(result == expResult);
        assertFalse(result != expResult);
        System.out.println("getNext method PASSED!!!");
    }
}
