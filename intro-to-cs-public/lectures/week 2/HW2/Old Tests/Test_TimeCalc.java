import java.util.Scanner;

public class Test_TimeCalc {

	public static void main(String[] args) {
		String time = args[0];
		int add = Integer.parseInt(args[1]);
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] parsed = s.split(" ");
        String[] ans = time(time, add);
        
        if (parsed.length < 2) {
        	System.out.print("TimeCalc\t" + false +"\t output not in format <time>space<AM/PM>.");
			sc.close();
			return;
        }
        if(ans[0].equals("Invalid input")){
        	boolean flag = parsed[0].contains("valid");
        	System.out.print("TimeCalc\t" + flag +"\t");
			if(!flag){
				System.out.println("Expected: Invalid input\t Received: " + parsed[0]);
			} else{
				System.out.println();
			}
        	sc.close();
        	return;
        }
        String[] rec = {parsed[0], parsed[1]};
        
        boolean flag = ans[0].equals(rec[0]) && ans[1].equals(rec[1]);
		System.out.print("TimeCalc\t" + flag +"\t");
		if(!flag){
			System.out.println("Expected: " + (ans[0] + " " + ans[1]) +"\t Received: " + (parsed[0] + " " + parsed[1]));
		} else{
			System.out.println();
		}
        
        sc.close();
	}
	
	public static String[] time(String s, int add){
		int hours = Integer.parseInt("" + s.charAt(0) + s.charAt(1));
		int minutes = Integer.parseInt("" + s.charAt(3) + s.charAt(4));
		String[] ans = new String[2];
		
		if(hours > 23 || minutes > 59 || hours < 0 || minutes < 0){
				ans[0] = "Invalid input";
		} else {
			int newMinutes = (minutes + add) % 60;
			int newHours = ((minutes + add) / 60 + hours) % 24;
			boolean pm = (newHours > 12);
			ans[0] = "" + ((pm) ? (newHours - 12) : newHours);
			ans[0] += ":";
			ans[0] += "" + ((newMinutes >= 10) ? newMinutes : ("0" + newMinutes));
			ans[1] = (pm) ? "PM" : "AM";
		}
		return ans;
	}

}
