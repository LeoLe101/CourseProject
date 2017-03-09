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
    private int sentValue;

    /**
     * This is the complete constructor of the exception
     *
     * @param lowestIndex the lowest index that the index can be
     * @param highestIndex the highest index that the index can be
     */
    public InvalidIndexException(int lowestIndex, int highestIndex,
            int sentValue) {
        super("THE INDEX ONLY VALID FROM " + lowestIndex
                + " TO " + highestIndex + "!\n Your input: " + sentValue);
        this.lowestIndex = lowestIndex;
        this.highestIndex = highestIndex;
        this.sentValue = sentValue;
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
     * Getting the highest index that the index can be
     *
     * @return the highest index
     */
    public int getHighestIndex() {
        return highestIndex;
    }

    /**
     * Getting the sent value from the user
     *
     * @return the value that user sent
     */
    public int getSentValue() {
        return sentValue;
    }

}
