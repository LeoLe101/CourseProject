package numberlist.primitivelist;


/**
 *
 * @author Phuc Hong Le
 * @version 1 (01/17/2017)
 */
public class NumberArrayList {

    //fields
    private long[] list;
    private int count;

    //default constructor 
    /**
     * 
     */
    public NumberArrayList() {
    }

    //complete constructor
    /**
     * 
     * @param list
     * @param count 
     */
    public NumberArrayList(long[] list, int count) {
        this.list = list;
        this.count = count;
    }

    //methods
    /**
     * 
     * @param index
     * @param value 
     */
    public void add(int index, long value) {
        
    }

    /**
     * 
     * @param index 
     */
    public void removeAt(int index) {
        for (int i = 0; i < list.length; i++) {
            if (index == list[i]) {
                
            }
        }
    }

    /**
     * 
     * @param value 
     */
    public void remove(long value) {
        for (int i = 0; i < 10; i++) {
            if (value == list[i]) {
                
            }
   
        }
    }

    /**
     * Getting the value within the ArrayList
     * 
     * @param index
     * @return 
     */
    public long get(int index) {
        return list[index];
    }

    /**
     * Finding the index within the ArrayList
     * 
     * @param value
     * @return 
     */
    public int find(long value) {
        for (int i = 0; i < list.length; i++) {
            if (value == list[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Getting the size of the ArrayList
     * 
     * @return the size of the ArrayList
     */
    public int size() {
        return list.length;
    }

    /**
     * Overriding the toString method
     * 
     * @return the string line we want toString to be
     */
    @Override
    public String toString() {
        return "NumberArrayList{" + "list=" + list + ", count=" + count + '}';
    }

}
