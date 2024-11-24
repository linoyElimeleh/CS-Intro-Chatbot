import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test_TestRandom {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try{
	        sc.nextLine();
	        sc.nextLine();
	        String s = sc.nextLine();
	        String parsed = test(s);
	        boolean flag = Math.abs(Double.parseDouble(parsed) - 1) < 0.1;
	        System.out.println("CalcExp\t" + flag);
	        sc.close();
		} catch(Exception e){
        	System.out.print("TestRandom\t" + false +"\t not enough lines of output");
        	sc.close();
		}
	}
	
    private static String test(String s) {
        Pattern p = Pattern.compile("[0-9]+[.][0-9]*");
        Matcher m = p.matcher(s);
        String result = "";
        if (m.find()) {
            result = s.substring(m.start(), m.end());
        }
       
        return result;
    }
}
