import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test_FVCalc {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = test(s);
        int result = solution(args[0], args[1], args[2]);

        boolean flag = Integer.parseInt(s) == result;
        System.out.println("FVCalc\t"+flag);
        sc.close();
    }

    private static String test(String s) {
        Pattern p = Pattern.compile("[0-9]+[.]?$");
        Matcher m = p.matcher(s);
        String result = "";
        if (m.find()) {
            result = s.substring(m.start(), m.end());
        }

        if (result.charAt(result.length() - 1) == '.') {
            result = result.substring(0, result.length() - 1);
        } 
        
       
        return result;
    }

    private static int solution(String x, String y, String z) {
        int currentValue = Integer.parseInt(x);
		double percent = Double.parseDouble(y);
		int numOfYears = Integer.parseInt(z);
		double rate = percent / 100;
		double futureValue = currentValue * Math.pow(1 + rate, numOfYears);
		return (int)futureValue;
    }
}
