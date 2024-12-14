
public class Algebra_Test {
	public static void main(String[] args) {
		
		testPlus(1, 2);
		testPlus(2, 1);
		testPlus(4, 0);
		testPlus(0, 4);
		testPlus(198, 37);
		
		testMinus(2, 1);
		testMinus(198, 37);
		testMinus(1217, 650);
		testMinus(0, 0);
		testMinus(10, 0);
		
		testTimes(1, 2);
		testTimes(2, 1);
		testTimes(4, 0);
		testTimes(0, 4);
		testTimes(198, 37);
		
		testPow(1, 8);
		testPow(10, 1);
		testPow(6, 0);
		testPow(0, 7);
		testPow(2, 19);
		
		testDiv(1, 8);
		testDiv(10, 3);
		testDiv(6, 5);
		testDiv(0, 9);
		testDiv(1948, 327);
		
		testMod(1, 8);
		testMod(10, 3);
		testMod(6, 5);
		testMod(0, 9);
		testMod(1948, 327);

		for (int i = 0; i < 5; i++) {
			int rand = (int)(Math.random()* 987) + 1;
			try{
				test("sqrt", Algebra.sqrt(rand) == sqrt(rand), rand, 0);
			} catch(Exception e){
				System.out.println("sqrt" + "\tfalse" + "\t exception thrown with input: " + rand);
			}
		}
	}
	
	public static void testMod (int input1, int input2){
		String func = "mod";
		try{
			test(func, Algebra.mod(input1, input2) == mod(input1, input2), input1, input2);
		} catch(Exception e){
			System.out.println(func + "\tfalse" + "\t exception thrown with inputs: " + input1 + ", " + input2);
		}
	}
	
	public static void testDiv (int input1, int input2){
		String func = "div";
		try{
			test(func, Algebra.div(input1, input2) == div(input1, input2), input1, input2);
		} catch(Exception e){
			System.out.println(func + "\tfalse" + "\t exception thrown with inputs: " + input1 + ", " + input2);
		}
	}
	
	public static void testPlus (int input1, int input2){
		String func = "plus";
		try{
			test(func, Algebra.plus(input1, input2) == plus(input1, input2), input1, input2);
		} catch(Exception e){
			System.out.println(func + "\tfalse" + "\t exception thrown with inputs: " + input1 + ", " + input2);
		}
	}
	
	public static void testMinus (int input1, int input2){
		String func = "minus";
		try{
			test(func, Algebra.minus(input1, input2) == minus(input1, input2), input1, input2);
		} catch(Exception e){
			System.out.println(func + "\tfalse" + "\t exception thrown with inputs: " + input1 + ", " + input2);
		}
	}
	
	public static void testTimes (int input1, int input2){
		String func = "times";
		try{
			test(func, Algebra.times(input1, input2) == times(input1, input2), input1, input2);
		} catch(Exception e){
			System.out.println(func + "\tfalse" + "\t exception thrown with inputs: " + input1 + ", " + input2);
		}
	}
	
	public static void testPow (int input1, int input2){
		String func = "pow";
		try{
			test(func, Algebra.pow(input1, input2) == pow(input1, input2), input1, input2);
		} catch(Exception e){
			System.out.println(func + "\tfalse" + "\t exception thrown with inputs: " + input1 + ", " + input2);
		}
	}
	
	public static void test (String func, boolean res , int input1, int input2) {
			if (!res) System.out.println(func + "\t" + res +"\t with inputs: " + input1 + ", " + input2);
			else System.out.println(func + "\t" + res);
	}
	
	// Returns x1 + x2.
	// Assumption: x1 and x2 are nonnegative.
	public static int plus(int x1, int x2) {
		int result = x1;
		int count = 0;
	    while (count < x2) {
	    	result++;
	    	count++;
	    }
	    return result;
	}

	// Returns x1 - x2.
	// Assumption: x1 and x2 are nonnegative, and x1 >= x2.
	public static int minus(int x1, int x2) {
		int result = x1;
		int count = 0;
	    while (count < x2) {
	    	result--;
	    	count++;
	    }
	    return result;
	}

	// Returns x1 * x2.

	public static int times(int x1, int x2) {
        int result = 0;
		int count = 0;
		while (count < x2) {
	        result = plus(result,x1);
	    	count++;
	    } 
	    return result;
	}

	// Returns x^n.
	// Assumption: x and n are nonnegative.
	public static int pow(int x, int n) {
		if (n == 0) return 1;
        int result = 1;
	    do {
	        result = times(result,x);
	    	n--;
	    } while (n > 0);
	    return result;
	}

	// Returns x1 / x2 (integer division). 
	// Assumption: x1 is nonnegative, x2 is positive.
	public static int div(int x1, int x2) {
        int result = 0;
        int numerator = x2;
        while (x1 >= x2){
        	x2 = plus(x2, numerator);
        	result++;
        }
        return result;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
        return minus(x1,times(x2,div(x1,x2)));
	}	

	// Returns the integer part of sqrt(x) 
	// Assumption: x >= 1.
	public static int sqrt(int x) {
        int result = 1;
		while (times(result,result) <= x) {
		    result++;	
		}
		return --result;
	}	  	  
}
