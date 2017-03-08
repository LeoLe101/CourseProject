package numberlist.objectlist;

/**
 * This Money class represent the U.S. currency (Immutable class)
 *
 * @author Phuc Hong Le
 * @version 1 (01/23/2017)
 */
public final class Money implements Copiable, Comparable<Money> {

    //fields
    private final long dollars;
    private final byte cents;

    //default constuctor and complete constructor
    /**
     * This is the default constructor
     */
    public Money() {
        dollars = 0;
        cents = 0;
    }

    /**
     * This is the complete constructor
     *
     * @param dollars The amount of dollars
     * @param cents The amount of cents
     */
    public Money(long dollars, byte cents) {
        long value = dollars * 100;
        value += cents;
        this.dollars = value / 100;
        this.cents = (byte) (value % 100);
    }

    //methods
    /**
     * Getting the dollar amount
     *
     * @return The amount of dollars
     */
    public long getDollars() {
        return dollars;
    }

    /**
     * Getting the cents amount
     *
     * @return The amount of cents
     */
    public byte getCents() {
        return cents;
    }

    /**
     * Adding the Money object to another
     *
     * @param other The Money value we want to add
     * @return The Money value
     */
    public Money add(Money other) {
        long currMoneytotal = dollars * 100;
        currMoneytotal += cents;
        long otherMoneyTotal = other.dollars * 100;
        otherMoneyTotal += other.cents;
        long result = currMoneytotal + otherMoneyTotal;
        return new Money(result / 100, (byte) (result % 100));
    }

    /**
     * Subtracting the Money object from the class
     *
     * @param other The Money value we want to subtract
     * @return The Money value
     */
    public Money subtract(Money other) {
        long currMoneytotal = dollars * 100;
        currMoneytotal += cents;
        long otherMoneyTotal = other.dollars * 100;
        otherMoneyTotal += other.cents;
        long result = currMoneytotal - otherMoneyTotal;
        return new Money(result / 100, (byte) (result % 100));
    }

    /**
     * Overriding the toString method
     *
     * @return The string we want for output
     */
    @Override
    public String toString() {
        return "$" + dollars + "." + cents;
    }

    /**
     * This will make a deep copy of the array
     *
     * @return Copiable value of money
     */
    @Override
    public Money deepCopy() {
        Money copy = new Money(this.dollars, this.cents);
        return copy;
    }

    /**
     * This will compare all values within the class
     *
     * @param other Money object
     * @return whether it is less than, equal or greater than each other
     */
    @Override
    public int compareTo(Money other) {
        int compare = 0;
        //compare real
        compare = Long.compare(this.dollars, other.dollars);
        if (compare != 0) {
            return compare;
        }
        //compare imaginary
        compare = Byte.compare(this.cents, other.cents);
        if (compare != 0) {
            return compare;
        }
        return compare;
    }

}
