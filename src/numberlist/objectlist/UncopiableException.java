package numberlist.objectlist;

/**
 * This class is a custom exception for un-copiable object that is not 
 * an instance of Copiable class
 * 
 * @author Phuc Hong Le
 * @version 1 (3/1/2017)
 */
public class UncopiableException extends Exception{
 
    /**
     * Default constructor for the Uncopiable Exception
     */
    public UncopiableException(){
        super("message");
    }    
}
