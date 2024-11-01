import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test_Collatz {
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Scanner sc = new Scanner(System.in);
		try{
			for (int i = 1; i <= n; i++) {
				String s = sc.nextLine();
				String ans = collatz(i);
				boolean flag = s.equals(ans);
				if(!flag){
					System.out.print("Collatz\t" + false +"\t Expected: " + ans + "\tReceived: " + s);
					sc.close();
					return;
				}
			}
			System.out.println("Collatz\t" + true);
			sc.close();
		} catch(Exception e){
        	System.out.print("Collatz\t" + false +"\t not enough lines of output");
        	sc.close();
		}
	}
	
	public static String collatz(int x){
		String output = x + " ";
		// Generates a hailstorm sequence, until it reaches 1.
		for (int i = 2; true; i++) {
			if (x % 2 == 0) {
				x = x / 2;
			}
			else {
				x = 3 * x + 1;
			}
			output = output + x + " ";
			if (x == 1) {
				// If the mode is "verbose", prints the sequence
				output = output + "(" + i + ")";
				break;
			}
		}
		return output;
	}
	
}
