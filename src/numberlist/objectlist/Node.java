package numberlist.objectlist;

/**
 * This Node class helps to keep track of the array and make it easier to grow,
 * add and remove elements by using node
 *
 * @author Phuc Hong Le
 * @version 1 (02/02/2017)
 */
public class Node {

    //fields
    private Node nextNode;
    private Object obj;

    //default constructor
    /**
     * Default constructor
     *
     * @param obj the object value of this node
     */
    public Node(Object obj) {
        this.obj = obj;
    }

    //methods
    /**
     * Getting the value from the current node
     *
     * @return the object value
     */
    public Object getValue() {
        return obj;
    }

    /**
     * Setting up the value of current node
     *
     * @param obj the object to be set
     */
    public void setValue(Object obj) {
        this.obj = obj;
    }

    /**
     * Getting the next node
     *
     * @return the next node
     */
    public Node getNext() {
        return nextNode;
    }

    /**
     * Setting the next node value
     *
     * @param node the next node value
     */
    public void setNext(Node node) {
        this.nextNode = node;
    }
}
