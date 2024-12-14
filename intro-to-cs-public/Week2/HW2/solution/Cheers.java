// Prints a crowd cheering output.
public class Cheers {
    public static void main(String[] args) {
        String text = args[0].toUpperCase();
        int times = Integer.parseInt(args[1]);
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
			if ("AEFHILMNORSX".indexOf(c) != -1){
				System.out.println("Give me an " + c + ": " + c + "!");
			} else {
				System.out.println("Give me a  " + c + ": " + c + "!");
			}
        }
        System.out.println("What does that spell?");
        for (int i = 0; i < times; i++) {
            System.out.println(text + "!!!");
        }
    }
}
