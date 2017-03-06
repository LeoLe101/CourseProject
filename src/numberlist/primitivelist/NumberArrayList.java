package numberlist.primitivelist;

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
        list = new long[count];
        count = 0;
    }

    //methods
    /**
     * This method will add the value into desired location in the array
     *
     * @param index the location in the array
     * @param value the long value
     */
    public void add(int index, long value) {
        //when the element is equal with the array's length, double the array
        if (index > count) {
            return;
        } else if (index <= count) {
            //when the element is equal with the array's length, double the array
            if (count == list.length || index == list.length - 1) {
                long[] listDouble;
                int firstArrayLimit = list.length + 1;
                listDouble = new long[firstArrayLimit];
                for (int i = 0; i < list.length; i++) {
                    listDouble[i] = list[i];
                }
                list = listDouble;
            }
            //find and put the value at the specific index
            if (index == count) {
                list[index] = value;
                count++;
            } else if (index < count) {
                for (int i = list.length - 1; i > index; i--) {
                    list[i] = list[i - 1];
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
    public void removeAt(int index) {
        long[] listShrink;
        boolean check = false;
        try {
            //move the array element over the index to be removed
            if (index == 0 && list.length == 1) {
                listShrink = new long[list.length - 1];
                list = listShrink;
            } else if (index < list.length && index != -1) {
                listShrink = new long[list.length - 1];
                for (int i = 0; i < list.length - 1; i++) {
                    if (i != index) {
                        listShrink[i] = list[i];
                    } else {
                        listShrink[i] = list[i + 1];
                        check = true;
                        break;
                    }
                }
                if (check == true) {
                    for (int i = listShrink.length - 1; i > index; i--) {
                        listShrink[i] = list[i - 1];
                    }
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
     * @param value the value to be deleted
     */
    public void remove(long value) {
        try {
            int index = find(value);
            removeAt(index);
        } catch (IndexOutOfBoundsException i) {
            System.out.println("Your input is out of bound");
        }
    }

    /**
     * Getting the value within the ArrayList
     *
     * @param index the index of the value
     * @return the element of that index in the array
     */
    public long get(int index) {
        try {
            return list[index];
        } catch (IndexOutOfBoundsException i) {
            return Long.MIN_VALUE;
        }
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
        return list.length;
    }

    /**
     * Overriding the toString method [ 1, 2, 1 ]
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
