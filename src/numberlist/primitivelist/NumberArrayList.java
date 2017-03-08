package numberlist.primitivelist;

import numberlist.InvalidIndexException;
import numberlist.objectlist.UncopiableException;

/**
 * This default class hold an array of long value for the class which consists
 * methods that is similar to an array-list
 *
 * @author Phuc Hong Le
 * @version 1 (01/17/2017)
 */
class NumberArrayList {

    //fields
    private long[] list;
    private int count;

    //default constructor 
    /**
     * This is the default constructor
     */
    public NumberArrayList() {
        list = new long[10];
        count = 0;
    }

    //methods
    /**
     * This method will add the value into desired location in the array
     *
     * @param index the location in the array
     * @param value the long value
     */
    public void add(int index, long value)
            throws InvalidIndexException {
        //catch if the index is valid or not
        if (index > count || index < 0) {
            throw new InvalidIndexException(0, count - 1);
        } else if (index <= count) {
            //when the element is equal with the array's length, double the array
            if (count == list.length) {
                long[] listDouble = new long[list.length * 2];
                System.arraycopy(list, 0, listDouble, 0, list.length);
                list = listDouble;
            }
            //find and put the value at the specific index
            if (index == count) {
                list[index] = value;
                count++;
            } else if (index < count) {
                for (int i = count - 1; i > index; i--) {
                    list[i + 1] = list[i];
                }
                list[index] = value;
                count++;
            }

        }
    }

    /**
     * Removing the value in the array at it's index
     *
     * @param index the index of the value to be deleted
     */
    public void removeAt(int index)
            throws InvalidIndexException {
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
     * @param value the value to be deleted
     */
    public void remove(long value)
            throws InvalidIndexException {
        int index = find(value);
        removeAt(index);
    }

    /**
     * Getting the value within the ArrayList
     *
     * @param index the index of the value
     * @return the element of that index in the array
     */
    public long get(int index)
            throws InvalidIndexException {
        if (index >= count || index < 0) {
            throw new InvalidIndexException(0, count - 1);
        }
        return list[index];
    }

    /**
     * Finding the index within the ArrayList
     *
     * @param value the value we want to find in the array
     * @return the index of that current value
     */
    public int find(long value) {
        int index = -1;
        for (int i = 0; i < list.length && index < 0; i++) {
            if (value == list[i]) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Getting the size of the ArrayList
     *
     * @return the size of the ArrayList
     */
    public int size() {
        return count;
    }

    /**
     * Overriding the toString method [ 1, 2, 1 ]
     *
     * @return The string line we want to return
     */
    @Override
    public String toString() {
        String stringOutPut = "";
        for (int i = 0; i < count; i++) {
            stringOutPut += list[i] + ", ";
        }
        stringOutPut = stringOutPut.substring(0, stringOutPut.length() - 2);
        return "[ " + stringOutPut + " ]";
    }

}
