import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test_CalcPI {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		Scanner sc = new Scanner(System.in);
		try{
	        String s = sc.nextLine();
	        String parsed = test(s);
	        boolean flag1 = Double.parseDouble(parsed) == Math.PI;
			if (!flag1){
	        	System.out.print("CalcPI\t" + false +"\t Expected: " + Math.PI + "\tReceived: " + parsed);
				sc.close();
				return;
			}
	        s = sc.nextLine();
	        parsed = test(s);
	        boolean flag2 = Math.abs(Double.parseDouble(parsed) - pi(N)) < 0.1;
			if (!flag2){
	        	System.out.print("CalcPI\t" + false +"\t Expected: " + pi(N) + "\tReceived: " + parsed);
				sc.close();
				return;
			}
	        System.out.println("CalcPI\t" + true);
	        sc.close();
		} catch(Exception e){
        	System.out.print("CalcPI\t" + false +"\t not enough lines of output");
        	sc.close();
		}
	}

	public static double pi(int N){
		double sum = 0;
		double numerator = 1;
		for (int i = 0; i < N; i++) {
    	    sum += numerator / (2 * i + 1);
    	    numerator = - numerator;
	    }
		return 4*sum;
	}
	
    private static String test(String s) {
        Pattern p = Pattern.compile("[0-9]+[.][0-9]{4,}");
        Matcher m = p.matcher(s);
        String result = "";
        if (m.find()) {
            result = s.substring(m.start(), m.end());
        }
       
        return result;
    }
}
