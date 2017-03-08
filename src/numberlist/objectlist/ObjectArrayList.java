package numberlist.objectlist;

import java.util.Arrays;
import numberlist.InvalidIndexException;

/**
 * This class hold an array of Object value for the class which consists methods
 * that is similar to an array-list
 *
 * @author Phuc Hong Le
 * @version 1 (01/17/2017)
 */
public class ObjectArrayList extends ObjectList implements Copiable {

    //fields
    private Object[] list;
    private int count;

    //default constructor
    /**
     * This is the default constructor
     */
    public ObjectArrayList() {
        count = 0;
        list = new Object[10];
    }

    //methods
    /**
     * Adding a new object value to the array at a specific index
     *
     * @param index The index where the object value is put
     * @param obj The object value we want to add
     */
    @Override
    public void add(int index, Object obj)
            throws InvalidIndexException, UncopiableException {
        try {
            Copiable copy = (Copiable) obj;
        } catch (Exception e) {
            throw new UncopiableException();
        }
        //cases prevent the index to go out of bound
        if (index > count || index < 0) {
            throw new InvalidIndexException(0, count - 1);
        } else if (index <= count) {
            //when the element is equal with the array's length, double the array
            if (count == list.length) {
                Object[] listDouble;
                int firstArrayLimit = list.length + 1;
                listDouble = new Object[firstArrayLimit];
                for (int i = 0; i < list.length; i++) {
                    listDouble[i] = list[i];
                }
                list = listDouble;
            }
            //find and put the value at the specific index
            if (index == count) {
                list[index] = obj;
                count++;
            } else if (index < count) {
                for (int i = 0; i < list.length - 1; i++) {
                    list[i + 1] = list[i];
                }
                list[index] = obj;
                count++;
            }
        }
    }

    /**
     * Removing the object value at a certain index
     *
     * @param index The index of the object we want to delete
     */
    @Override
    public void removeAt(int index) throws InvalidIndexException {
        //move the array element over the index to be removed
        if (index >= count || index < 0) {
            throw new InvalidIndexException(0, count - 1);
        }
        for (int i = index + 1; i < count; i++) {
            list[i - 1] = list[i];
        }
        count--;
    }

    /**
     * Removing the value in the array
     *
     * @param obj the value to be deleted
     */
    @Override
    public void remove(Object obj) throws InvalidIndexException {
        try {
            int index = find(obj);
            removeAt(index);
        } catch (IndexOutOfBoundsException i) {
            throw new InvalidIndexException(0, count - 1);
        }
    }

    /**
     * Getting the object value from the array
     *
     * @param index For the object value we want to get in the array
     * @return The object value inside the array
     */
    @Override
    public Object get(int index) throws InvalidIndexException {
        if (index >= count || index < 0) {
            throw new InvalidIndexException(0, count - 1);
        }
        return list[index];
    }

    /**
     * Finding the index of the array
     *
     * @param obj The object we want to find the index of
     * @return The index of that object in the array
     */
    @Override
    public int find(Object obj) {
        int index = -1;
        for (int i = 0; i < count && index < 0; i++) {
            if (obj == list[i]) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Overriding the toString method
     *
     * @return The string line we want to return
     */
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < count; i++) {
            output += list[i] + ", ";
        }
        output = output.substring(0, output.length() - 2);
        return "[ " + output + " ]";
    }

    /**
     * This will make a deep copy of the array
     *
     * @return Copiable value of the object array list
     */
    @Override
    public ObjectArrayList deepCopy()
            throws InvalidIndexException, UncopiableException {
        ObjectArrayList copy = new ObjectArrayList();
        for (int i = 0; i < list.length; i++) {
            copy.add(i, ((Copiable) list[i]).deepCopy());
        }
        return copy;
    }

}
