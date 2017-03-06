package numberlist.objectlist;

/**
 * This class represent a complex number (Immutable class)
 *
 * @author Phuc Hong Le
 * @version 1 (01/23/2017)
 */
public final class Complex implements Copiable, Comparable<Complex> {

    //fields
    private double real;
    private double imaginary;

    //default constructor and complete constructor
    /**
     * This is the default constructor
     */
    public Complex() {
    }

    /**
     * This is the complete constructor
     *
     * @param real The real value
     * @param imaginary The imaginary value
     */
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    //methods
    /**
     * Getting the real value from the Complex class
     *
     * @return The real value
     */
    public double getReal() {
        return real;
    }

    /**
     * Getting the imaginary value
     *
     * @return The imaginary value
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Adding more Complex value
     *
     * @param other Complex value
     * @return The Complex value
     */
    public Complex add(Complex other) {
        Complex currComplex = new Complex(real, imaginary);
        currComplex.real += other.getReal();
        currComplex.imaginary = currComplex.imaginary + other.getImaginary();
        return currComplex;
    }

    /**
     * Subtracting the Complex value
     *
     * @param other Complex value
     * @return The Complex value
     */
    public Complex subtract(Complex other) {
        Complex currComplex = new Complex(real, imaginary);
        currComplex.real -= other.getReal();
        currComplex.imaginary = currComplex.imaginary - other.getImaginary();
        return currComplex;
    }

    /**
     * Overriding the toString method
     *
     * @return The string line we want to output
     */
    @Override
    public String toString() {
        return real + " + " + imaginary + 'i';
    }

    /**
     * This will make a deep copy of the array
     *
     * @return Copiable value of complex
     */
    @Override
    public Complex deepCopy() {
        Complex copy = new Complex(this.real, this.imaginary);
        return copy;
    }

    /**
     * This will compare all values within the class
     *
     * @param other Complex object
     * @return whether it is less than, equal or greater than each other
     */
    @Override
    public int compareTo(Complex other) {
        int compare = 0;
        //compare real
        compare = Double.compare(this.real, other.real);
        if (compare != 0) {
            return compare;
        }
        //compare imaginary
        compare = Double.compare(this.imaginary, other.imaginary);
        if (compare != 0) {
            return compare;
        }
        return compare;
    }

}
