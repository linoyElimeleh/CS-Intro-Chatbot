import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test_TimeFormat {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] parsed = test(s);
        String[] result = solution(args[0]);

        boolean testHours = Integer.parseInt(parsed[0]) == Integer.parseInt(result[0]);
        boolean testMinutes = Integer.parseInt(parsed[1]) == Integer.parseInt(result[1]);
        boolean testAMPM = result[2].equalsIgnoreCase(parsed[2]);
        
        boolean flag = testHours && testMinutes && testAMPM;
        System.out.println("TimeFormat\t"+flag);
        sc.close();
    }

    private static String[] test(String s) {
        String[] result = new String[3];

        Pattern p = Pattern.compile("^[0-9]+:");
        Matcher m = p.matcher(s);
        
        m.find();
        result[0] = s.substring(m.start(), m.end() - 1);

        p = Pattern.compile(":[0-9]+");
        m = p.matcher(s);

        m.find();
        result[1] = s.substring(m.start() + 1, m.end());

        p = Pattern.compile(".[mM]");
        m = p.matcher(s);
        m.find();
        result[2] = s.substring(m.start(), m.end());
       
        return result;
    }

    private static String[] solution(String s) {
        String[] result = new String[3];

		int hours = Integer.parseInt("" + s.charAt(0) + s.charAt(1));
		// Does the same with the minute digits.
		int minutes = Integer.parseInt("" + s.charAt(3) + s.charAt(4));
        // Prints the time using an AM/PM notation
        result[2] = (hours >= 12) ? "PM" : "AM";
        result[0] = (hours > 12) ? ""+(hours - 12) : ""+hours;
        result[1] = (minutes >= 10) ? ""+minutes : ("0" + minutes);

        return result;
    }
}
