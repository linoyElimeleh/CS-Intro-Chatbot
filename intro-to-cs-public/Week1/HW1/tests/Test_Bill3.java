import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Test_Bill3 {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = test(s);
        x = Math.ceil(x / 3);
        boolean flag = Double.parseDouble(s) == x;
        System.out.println("Bill3\t"+flag);
        sc.close();
    }

    private static String test(String s) {
        Pattern p = Pattern.compile("[0-9]+[.]0");
        Matcher m = p.matcher(s);
        String result = "";
        if (m.find()) {
            result = s.substring(m.start(), m.end());
        }
       
        return result;
    }
}