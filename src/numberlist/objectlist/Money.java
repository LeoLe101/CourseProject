package numberlist.objectlist;

/**
 *
 * @author Phuc Hong Le
 * @version 1 (01/23/2017)
 */
public class Money {
    //fields
    private long dollars;
    private byte cents;
    
    //default constuctor and complete constructor
    /**
     * This is the default constructor
     */
    public Money (){
    }
    
    /**
     * This is the complete constructor
     * 
     * @param dollars The amount of dollars
     * @param cents The amount of cents
     */
    public Money(long dollars, byte cents){
        this.dollars = dollars;
        this.cents = cents;
    }
    
    //methods
    /**
     * Getting the dollar amount 
     * 
     * @return The amount of dollars
     */
    public long getDollars(){
        return dollars;
    }
    
    /**
     * Getting the cents amount
     * 
     * @return The amount of cents
     */
    public byte getCents(){
        return cents;
    }
    
    /**
     * Adding the Money object to the class
     * 
     * @param other The Money value we want to add
     * @return The Money value
     */
    public Money add(Money other){
        return other;
    }
    
    /**
     * Subtracting the Money object from the class
     * 
     * @param other The Money value we want to subtract
     * @return The Money value
     */
    public Money subtract(Money other){
        return other;
    }

    /**
     * Overriding the toString method
     * 
     * @return The string we want for output
     */
    @Override
    public String toString() {
        return "Here is the value of dollars in Money = " 
                + dollars + " Here is the value of cents in Money = " 
                + cents;
    }
    
    
    
    
}
