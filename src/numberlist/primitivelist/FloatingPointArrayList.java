package numberlist.primitivelist;

/**
 * This default class represent an array-list of number from the project It will
 * use composition to create a floating point version of the NumberArrayList
 *
 * @author Phuc Hong Le
 * @version 1 (01/23/2017)
 */
class FloatingPointArrayList {

    //fields
    private NumberArrayList list;

    //default constructor
    /**
     * This is the default constructor
     */
    public FloatingPointArrayList() {
        list = new NumberArrayList();
    }

    //methods
    /**
     * Adding a value to a specific index inside the array by calling add method
     * in NumberArrayList
     *
     * @param index The index of the array
     * @param value The value to add
     */
    public void add(int index, double value) {
        list.add(index, Double.doubleToRawLongBits(value));
    }

    /**
     * Removing the value in the array at it's index by calling removeAt method
     * in NumberArrayList
     *
     * @param index the index of the value to be deleted
     */
    public void removeAt(int index) {
        list.removeAt(index);
    }

    /**
     * Removing the value from the array by calling remove method in
     * NumberArrayList
     *
     * @param value The value we want to remove
     */
    public void remove(double value) {
        list.remove(Double.doubleToRawLongBits(value));
    }

    /**
     * Getting the value from a specific index by calling get method in
     * NumberArrayList
     *
     * @param index The index of the array
     * @return The value from the array
     */
    public double get(int index) {
        return Double.longBitsToDouble(list.get(index));
    }

    /**
     * Finding the index of a value by calling find method in NumberArrayList
     *
     * @param value The value we want to find the index of
     * @return The index of that value
     */
    public int find(double value) {
        return list.find(Double.doubleToRawLongBits(value));
    }

    /**
     * Finding the size of the array by calling size method in NumberArrayList
     *
     * @return The size of the array
     */
    public int size() {
        return list.size();
    }

    /**
     * Overriding the toString method
     *
     * @return The string line we want to return
     */
    @Override
    public String toString() {
         String stringOutPut = "";
        for (int b = 0; b < this.size(); b++) {
            if (b == this.size() - 1) {
                stringOutPut += this.get(b);
            } else {
                stringOutPut += this.get(b) + ", ";
            }
        }
        return "[ " + stringOutPut + " ]";
    }

}
