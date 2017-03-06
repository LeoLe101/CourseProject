package numberlist.objectlist;

/**
 * This class is a custom exception for un-copiable object that is not 
 * an instance of Copiable class
 * 
 * @author Phuc Hong Le
 * @version 1 (3/1/2017)
 */
public class UncopiableException extends Exception{
    
    //fields
    private Object obj;
    
    public UncopiableException(Object obj){
        super("YOUR INPUT: " + obj + " IS UNCOPIABLE");
        if (obj instanceof Copiable) {
        this.obj = obj;
        } 
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
    
}
