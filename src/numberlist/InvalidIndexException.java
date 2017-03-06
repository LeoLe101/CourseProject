package numberlist;

/**
 * This is a hand made exception for invalid index value for every class
 * that has an index value as a parameter
 * 
 * @author Phuc Hong Le
 * @version 1 (02/27/2017)
 */
public class InvalidIndexException extends Exception {
    
    //fields
    private int lowestIndex;
    private int highestIndex;
    
    public InvalidIndexException(int lowestIndex, int highestIndex){
        super("THE INDEX ONLY VALID FROM " + lowestIndex + " TO " + highestIndex);
        this.lowestIndex = lowestIndex;
        this.highestIndex = highestIndex;
    }

    public int getLowestIndex() {
        return lowestIndex;
    }

    public void setLowestIndex(int lowestIndex) {
        this.lowestIndex = lowestIndex;
    }

    public int getHighestIndex() {
        return highestIndex;
    }

    public void setHighestIndex(int highestIndex) {
        this.highestIndex = highestIndex;
    }
    

    
}
