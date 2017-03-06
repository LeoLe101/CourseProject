package numberlist.objectlist;

/**
 * This abstract class holds a list of object that can be accessed within this
 * package
 *
 * @author Phuc Hong Le
 * @version 1 (02/03/2017)
 */
abstract class ObjectList {

    //fields
    int count;

    //methods
    /**
     * Abstract class of adding the object to a specific index
     *
     * @param index the index of that object
     * @param obj the object value
     */
    abstract void add(int index, Object obj);

    /**
     * Abstract class of removing the object at it's index
     *
     * @param index the index of that object
     */
    abstract void removeAt(int index);

    /**
     * Abstract class of removing the object
     *
     * @param obj the object to be removed
     */
    abstract void remove(Object obj);

    /**
     * Abstract class of getting the object from it's index
     *
     * @param index the index of that specific object
     * @return the object
     */
    abstract Object get(int index);

    /**
     * Abstract class of finding the object and return the index
     *
     * @param obj the object to be found
     * @return the index of that object
     */
    abstract int find(Object obj);

    /**
     * Abstract of returning the size of the object list
     *
     * @return the size of the object list
     */
    public int size() {
        return count;
    }
}
