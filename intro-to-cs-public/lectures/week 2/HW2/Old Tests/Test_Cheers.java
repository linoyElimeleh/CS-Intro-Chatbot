import java.util.Scanner;

public class Test_Cheers {

	public static void main(String[] args) {
   	    String text = args[0];
        int N = Integer.parseInt(args[1]);
        Scanner sc = new Scanner(System.in);
        try{
        	for (int i = 0; i < text.length(); i++) {
				String s = sc.nextLine();
				boolean flag = s.contains(text.charAt(i) + "!");
				String prefix = "";
				if("aeiouAEIOU".indexOf(text.charAt(i)) >= 0){
					prefix = "an";
					flag = flag & s.contains(prefix);
				} else{
					prefix = "a";
					flag = flag & !s.contains("an");
				}
				if (!flag){
		        	System.out.print("Cheers\t" + false +"\t Expected: " + ("Give me " + prefix + ": "+ text.charAt(i) + "!: " + text.charAt(i)) +"!" + "\t\tReceived: " + s);
					sc.close();
					return;
				}
				
			}
        	sc.nextLine();
        	for (int i = 0; i < N; i++) {
        		String s = sc.nextLine();
        		boolean flag = s.contains(text);
				if (!flag){
		        	System.out.print("Cheers\t" + false +"\t Expected: " + text + "!!" + "\tReceived: " + s);
					sc.close();
					return;
				}
			}
        } catch(Exception e){
        	System.out.print("Cheers\t" + false +"\t not enough lines of output");
        	sc.close();
        }
        System.out.println("Cheers\t" + true);
        sc.close();
        
	}

}
