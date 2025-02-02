import java.util.Arrays;

// Tests the animal classes
public class FractionSortDemo {

    public static void main(String args[]) {
        // Creates an array of 5 random fractions
        Fraction[] fracs = new Fraction[5];
        for (int i = 0; i < fracs.length; i++)
            fracs[i] = new Fraction(10);

        // Sorts the fractions      
        Arrays.sort(fracs); 
        for (Fraction f : fracs)
            System.out.println(f);
    }
}
