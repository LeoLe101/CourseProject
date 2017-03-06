package numberlist.objectlist;

import java.util.Arrays;

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
        list = new Object[count];
    }

    //methods
    /**
     * Adding a new object value to the array at a specific index
     *
     * @param index The index where the object value is put
     * @param obj The object value we want to add
     */
    @Override
    public void add(int index, Object obj) {
        //cases prevent the index to go out of bound
        if (index > count) {
            return;
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
    public void removeAt(int index) {
        Object[] listShrink;
        Object[] listLimit;
        try {
            //move the array element over the index to be removed
            if (index == 0 && list.length == 1) {
                for (int i = index; i < list.length; i++) {
                    list[i] = null;
                }
                listShrink = new Object[list.length - 1];
                list = listShrink;
            } else if (index > 0 && list.length > 1) {
                listShrink = new Object[list.length - 1];
                for (int i = index; i < list.length; i++) {
                    listShrink[i - 1] = list[i - 1];
                }
                list = listShrink;
            }
        } catch (IndexOutOfBoundsException i) {
            System.out.println("Your input is out of bound");
        }

    }

    /**
     * Removing the value in the array
     *
     * @param obj the value to be deleted
     */
    @Override
    public void remove(Object obj
    ) {
        try {
            int index = find(obj);
            removeAt(index);
        } catch (IndexOutOfBoundsException i) {
            System.out.println("Your input is out of bound");
        }
    }

    /**
     * Getting the object value from the array
     *
     * @param index For the object value we want to get in the array
     * @return The object value inside the array
     */
    @Override
    public Object get(int index
    ) {
        try {
            return list[index];
        } catch (IndexOutOfBoundsException i) {
            return Long.MIN_VALUE;
        }
    }

    /**
     * Finding the index of the array
     *
     * @param obj The object we want to find the index of
     * @return The index of that object in the array
     */
    @Override
    public int find(Object obj
    ) {
        int index = -1;
        if (list.length == 1) {
            for (int i = 0; i < list.length && index < 0; i++) {
                if (obj == list[i]) {
                    index = i;
                }
            }
        } else {
            for (int i = 0; i < list.length - 1 && index < 0; i++) {
                if (obj == list[i]) {
                    index = i;
                }
            }
        }
        return index;
    }

    /**
     * Getting the size of the array
     *
     * @return The size of the array
     */
    @Override
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
        String stringOutPut = "";

        for (int b = 0; b < this.size(); b++) {
            if (b == this.size() - 1) {
                stringOutPut += this.get(b).toString();
            } else {
                stringOutPut += this.get(b).toString() + ", ";
            }
        }
        return "[ " + stringOutPut + " ]";
    }

    /**
     * This will make a deep copy of the array
     *
     * @return Copiable value of the object array list
     */
    @Override
    public ObjectArrayList deepCopy() {
        ObjectArrayList copy = new ObjectArrayList();
        for (int i = 0; i < list.length; i++) {
            copy.add(i, ((Copiable) list[i]).deepCopy());
        }
        return copy;
    }

}
