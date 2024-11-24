public class Loops{
	public static void main(String[] args){
		//while example
		int count = 0;
		while (count < 10) {
			count = count + 1;
			System.out.print("*");
		}
		
		// same code but using for
		for (int i=0;i<10;i++){
			System.out.print("*");
		}
		
		String s = "Make America great again";
		//Run on a the string s and count the number of 'a'
		count = 0;
		for (int i=0;i<s.length();i++){
			if (s.charAt(i) == 'a'){
				count++;
			}
		}
		System.out.println("the nubmer of 'a's is: " + count);
		
		

	}
}