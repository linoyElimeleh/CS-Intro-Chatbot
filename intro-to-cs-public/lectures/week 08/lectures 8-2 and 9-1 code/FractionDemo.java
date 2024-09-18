public class FractionDemo {
	
    public static void main(String []args) {

        Fraction a = new Fraction(1,3);
        Fraction b = new Fraction(3,7);
        Fraction c = new Fraction(2,5);

        // Computes 1/3 + 3/7        
        System.out.println(a + " + " + b + " = " + a.add(b));
        // Computes 1/3 * 3/7        
        System.out.println(a + " * " + b + " = " + a.multiply(b));

        // Computes 1/3 * (3/7 + 2/5)        
        Fraction d = a.multiply(b.add(c));
        System.out.println(a + " * ( " + b + " + " + c + " ) = " + d);

        // Computes 2/3 : 4/5 
        System.out.print("2/3 : 4/5 = ");
        System.out.println((new Fraction(2,3)).divide(new Fraction(4,5))); 
    }
}
