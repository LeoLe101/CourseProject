package numberlist.objectlist;

/**
 *
 * @author Phuc Hong Le
 * @version 1 (01/17/2017)
 */
public class ObjectArrayList {

    //fields
    private Object[] list;
    private int count;

    //default constructor
    /**
     * This is the default constructor
     */
    public ObjectArrayList() {
    }

    //methods
    /**
     * Adding a new object value inside the array to a specific index
     *
     * @param index The index where the object value is put
     * @param obj The object value we want to add
     */
    public void add(int index, Object obj) {

    }

    /**
     * Removing the object value at a certain index
     *
     * @param index The index of the object we want to delete
     */
    public void removeAt(int index) {
        for (int i = 0; i < list.length; i++) {
            if (index == i) {
                list[i] = null;
            }
        }
    }

    /**
     * Getting the object value from the array
     *
     * @param index For the object value we want to get in the array
     * @return The object value inside the array
     */
    public Object get(int index) {
        Object obj = null;
        for (int i = 0; i < list.length; i++) {
            if (index == i) {
                obj = list[i];
            }
        }
        return obj;
    }

    /**
     * Finding the index of the array
     *
     * @param obj The object we want to find the index of
     * @return The index of that object in the array
     */
    public int find(Object obj) {
        for (int i = 0; i < list.length; i++) {
            if (obj == list[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Getting the size of the array
     *
     * @return The size of the array
     */
    public int size() {
        return list.length;
    }

    /**
     * Overriding the toString method
     *
     * @return The string line we want to return
     */
    @Override
    public String toString() {
        return "ObjectArrayList{" + "list=" + list + ", count=" + count + '}';
    }

}
