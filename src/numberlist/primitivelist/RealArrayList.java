package numberlist.primitivelist;

import numberlist.InvalidIndexException;

/**
 * This class holds an array-list of real object
 *
 * @author Phuc Hong Le
 * @version 1 (02/02/2017)
 */
public class RealArrayList extends FloatingPointArrayList {

    //methods
    /**
     * Adding the value at the end of the list
     *
     * @param value the value to be added
     */
    public void add(double value)
            throws InvalidIndexException {
        super.add(super.size(), value);
    }

    /**
     * Removing all instances of the value from the existing list
     *
     * @param value the value to be removed
     */
    public void removeAll(double value) 
            throws InvalidIndexException{
        int index = find(value);
        while (index >= 0) {
            removeAt(index);
            index = find(value);
        }
    }

    /**
     * Finding the index number of the last element in the list
     *
     * @param value the value to be found
     * @return the last index of the value
     */
    public int findLast(double value)
            throws InvalidIndexException {
        int index = -1;
        //this loop will process from the last index to the first index
        for (int i = super.size() - 1; i >= 0 && index < 0; i--) {
            if (value == super.get(i)) {
                index = i;
            }
        }
        return index;
    }
}
