package numberlist;

/**
 * This is a hand made exception for invalid index value for every class that
 * has an index value as a parameter
 *
 * @author Phuc Hong Le
 * @version 1 (02/27/2017)
 */
public class InvalidIndexException extends Exception {

    //fields
    private int lowestIndex;
    private int highestIndex;

    /**
     * This is the complete constructor of the exception
     *
     * @param lowestIndex the lowest index that the index can be
     * @param highestIndex the highest index that the index can be
     */
    public InvalidIndexException(int lowestIndex, int highestIndex) {
        super("THE INDEX ONLY VALID FROM " + lowestIndex + " TO " + highestIndex);
        this.lowestIndex = lowestIndex;
        this.highestIndex = highestIndex;
    }

    /**
     * Getting the lowest index that the index can be
     *
     * @return the lowest index
     */
    public int getLowestIndex() {
        return lowestIndex;
    }

    /**
     * Setting the lowest index for the Exception
     *
     * @param lowestIndex the lowest index
     */
    public void setLowestIndex(int lowestIndex) {
        this.lowestIndex = lowestIndex;
    }

    /**
     * Getting the highest index that the index can be
     *
     * @return the highest index
     */
    public int getHighestIndex() {
        return highestIndex;
    }

    /**
     * Setting the highest index for the Exception
     *
     * @param highestIndex the highest index
     */
    public void setHighestIndex(int highestIndex) {
        this.highestIndex = highestIndex;
    }

}
