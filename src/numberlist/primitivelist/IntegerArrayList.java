package numberlist.primitivelist;

/**
 * This class holds an array-list of integer object
 *
 * @author Phuc Hong Le
 * @version 1 (02/02/2017)
 */
public class IntegerArrayList extends NumberArrayList {

    //methods
    /**
     * Adding the value at the end of the list
     *
     * @param value the value to be added
     */
    public void add(long value) {
        if (super.size() == 0) {
            super.add(super.size(), value);
        } else {
            super.add(super.size() - 1, value);
        }
    }

    /**
     * Removing all instances of the value from the existing list
     *
     * @param value the value to be removed
     */
    public void removeAll(long value) {
        int numInstance = 0;
        //find the number of instances of the value existing in the array
        for (int i = 0; i < super.size(); i++) {
            if (value == super.get(i)) {
                numInstance++;
            }
            if (numInstance > 0) {
                //delete until there are no instances of the value in the array
                do {
                    super.remove(value);
                    numInstance--;
                } while (numInstance > 0);
            }
        }
    }

    /**
     * Finding the index number of the last element in the list
     *
     * @param value the value to be found
     * @return the last index of the value
     */
    public int findLast(long value) {
        int index = -1;
        //this loop will process until the last index of that value
        for (int i = 0; i < super.size(); i++) {
            if (value == super.get(i)) {
                index = i;
            }
        }
        return index;
    }
}
