package numberlist.objectlist;

/**
 *
 * @author Phuc Hong Le
 * @version 1 (01/23/2017)
 */
public class Complex {
    //fields
    private double real;
    private double imaginary;
    
    //default constructor and complete constructor
    /**
     * This is the default constructor
     */
    public Complex(){
    }
    
    /**
     * This is the complete constructor 
     * 
     * @param real The real value
     * @param imaginary The imaginary value
     */
    public Complex(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    
    //methods
    /**
     * Getting the real value from the Complex class
     * 
     * @return The real value
     */
    public double getReal(){
        return real;
    }
    
    /**
     * Getting the imaginary value
     * 
     * @return The imaginary value
     */
    public double getImaginary(){
        return imaginary;
    }
    
    /**
     * Adding more Complex value 
     * 
     * @param other Complex value
     * @return The Complex value
     */
    public Complex add(Complex other){
        return other;
    }
    
    /**
     * Subtracting the Complex value
     * 
     * @param other Complex value
     * @return The Complex value
     */
    public Complex subtract(Complex other){
        return other;
    }

    /**
     * Overriding the toString method
     * 
     * @return The string line we want to output
     */
    @Override
    public String toString() {
        return "Here is the value of real = " + real 
                + " Here is the value of imaginary = " 
                + imaginary + '}';
    }
    
}
