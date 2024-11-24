import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test_NumWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] result = solution(args[0]);
        int[] parsed = test(s);
        boolean flag = true;
        for (int i = 0; i < parsed.length; i++) {
            flag = result[i] == parsed[i];
        }
        System.out.println("NumWords\t"+flag);
        sc.close();

    }

    public static int[] test(String s) {
        int[] result = new int[3];
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(s);
        int i = 0;
        while (m.find()) {
            result[i] = Integer.parseInt(s.substring(m.start(), m.end()));
            i++;
        }
        return result;
    }
    public static int[] solution(String y) {
        int[] result = new int[3];
	    int x = Integer.parseInt(y);
	    int hundreds = x / 100;
	    x = x - hundreds * 100;
	    int tens = x / 10;
        int ones = x - tens * 10;
        
        result[0] = hundreds;
        result[1] = tens;
        result[2] = ones;

        return result;
	}
}
