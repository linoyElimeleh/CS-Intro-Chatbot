/** Represents a Fraction */
public class Fraction implements Comparable<Fraction> {

    // The fields of this Fraction
    private int numerator;
    private int denominator;
  
    /** Constructs a fraction */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;   
    }

    /** Constructs a random fraction.
     *  The denominator is a random number d so that 2 <= d < limit. 
     *  The numerator is a random number n   so that 1 <= n < d.
     *  @param limit must be at least 2
     */
    public Fraction(int limit) {
        denominator = Math.max(2, (int) (limit * Math.random()));
        numerator = Math.max(1, (int) (Math.random() * (denominator)));
    }

    /** Compares this fraction with the other fraction.
    Returns 0 if the two fractions are equal,
    1 if this fraction is greater than the other, or -1 otherwise */
    public int compareTo(Fraction other) {
        if ((numerator == other.numerator) && 
            (denominator == other.denominator)) return 0;
        if (numerator * other.denominator > 
            other.numerator * denominator) return 1;
        else return -1;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}