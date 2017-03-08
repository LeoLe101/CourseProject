package numberlist.objectlist;

import numberlist.InvalidIndexException;

/**
 * This class linked the list of object with their nodes
 *
 * @author Phuc Hong Le
 * @version 1 (02/03/2017)
 */
public class ObjectLinkedList extends ObjectList implements Copiable {

    //fields
    private Node firstNode;

    //default constructor
    /**
     * Default constructor
     */
    public ObjectLinkedList() {
        firstNode = null;
        count = 0;
    }

    //methods
    /**
     * Adding the object to a specific index
     *
     * @param index the index of that object
     * @param obj the object value
     */
    @Override
    public void add(int index, Object obj)
            throws InvalidIndexException, UncopiableException {
        //catch if the object is an instance of Copiable or not
        try {
            Copiable copy = (Copiable) obj;
        } catch (Exception e) {
            throw new UncopiableException();
        }
        //catch if the index is valid or not
        if (index > count || index < 0) {
            throw new InvalidIndexException(0, count - 1);
        }
        //continue the process when every requirement passed
        Node newNode = new Node(obj);
        if (index == 0) {
            newNode.setNext(firstNode);
            firstNode = newNode;
        } else {
            Node currentNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
        count++;
    }

    /**
     * Removing the object at it's index
     *
     * @param index the index of that object
     */
    @Override
    public void removeAt(int index) throws InvalidIndexException {
        //catch if the index is valid or not
        if (index > count || index < 0) {
            throw new InvalidIndexException(0, count - 1);
        }
        Node currentNode = firstNode;
        Node exNode = null;
        //search for the node at that specific index and add it into the current
        for (int i = 0; i != index && currentNode.getNext() != null; i++) {
            currentNode = currentNode.getNext();
        }
        count--;
        //Only do when there are Node of object that is connected to the deleted
        //Node
        for (int i = index; i < size(); i++) {
            //set the current node to the location of the node next to the index's
            exNode = currentNode.getNext();
            currentNode.setNext(exNode.getNext());
            //set the exNode back to null for the next remove
            exNode = null;
        }
    }

    /**
     * Removing the object
     *
     * @param obj the object to be removed
     */
    @Override
    public void remove(Object obj) throws InvalidIndexException {
        try {
            int index = find(obj);
            removeAt(index);
        } catch (Exception e) {
            throw new InvalidIndexException(0, count - 1);
        }
    }

    /**
     * Getting the object from it's index
     *
     * @param index the index of that specific object
     * @return the object
     */
    @Override
    public Object get(int index) throws InvalidIndexException{
        //catch if the index is valid or not
        if (index > count || index < 0) {
            throw new InvalidIndexException(0, count - 1);
        }
        if (index == 0) {
            return firstNode.getValue();
        }
        Node currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    /**
     * Finding the object and return the index
     *
     * @param obj the object to be found
     * @return the index of that object
     */
    @Override
    public int find(Object obj) {
        int index = -1;
        Node newNode = new Node(obj);
        Node currentNode = firstNode;
        for (int i = 0; currentNode.getNext() != null && index < 0; i++) {
            if (newNode.getValue() == currentNode.getValue()) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Override the toString method
     *
     * @return the string line for output
     */
    @Override
    public String toString() {
        String stringOutPut = "";
        Node currentNode = firstNode;
        while (currentNode.getNext() != null) {
            stringOutPut += currentNode.getValue() + ", ";
            currentNode = currentNode.getNext();
        }
        stringOutPut += currentNode.getValue();
        return "[ " + stringOutPut + " ]";
    }

    /**
     * This will make a deep copy of the array
     *
     * @return an Object Linked List value of the list
     */
    @Override
    public ObjectLinkedList deepCopy()
            throws InvalidIndexException, UncopiableException {
        Node currentNode = firstNode;
        ObjectLinkedList copyList = new ObjectLinkedList();
        for (int i = 0; i < size(); i++) {
            copyList.add(i, ((Copiable) this.get(i)).deepCopy());
            currentNode = currentNode.getNext();
        }
        return copyList;
    }

}
