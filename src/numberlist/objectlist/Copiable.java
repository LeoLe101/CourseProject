package numberlist.objectlist;

import numberlist.InvalidIndexException;

/**
 * This interface class helps implements deepCopy 
 * method to other concrete classes
 * 
 * @author Phuc Hong Le
 * @version 1 (02/02/2017)
 */
public interface Copiable {
    
    public Copiable deepCopy() 
            throws InvalidIndexException, UncopiableException;
}
