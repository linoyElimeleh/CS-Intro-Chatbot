public class Test {
    public static void main(String[] args) {
        int N = 5000;
		int i = 0;
        int count = 0;
		while (i < N) {
			if (Math.random() > 0.5) {
				count++;
			}
			i++;
		}
        String s1 = "> 0.5:  " + count + " times.";
        String s2 = "<= 0.5: " + (N - count) + " times.";
        String s3 = "Ratio:  " +  (count+0.0) / (N - count);
        System.out.println(test(N,s1,s2,s3));
    }
    public static boolean test(int times, String s1,String s2,String s3){
        int num1 = Integer.parseInt(s1.substring(s1.indexOf(":")+3,s1.indexOf("t")-1));
        int num2 = Integer.parseInt(s2.substring(s2.indexOf(":")+2,s2.indexOf("t")-1));
        double ratio = Double.parseDouble(s3.substring(s3.indexOf('0')));
        return(s1.substring(0,s1.indexOf(":")).equals("> 0.5")
            && s2.substring(0,s2.indexOf(":")).equals("<= 0.5")
            && s1.substring(s1.indexOf("t")).equals("times.")
            && s2.substring(s2.indexOf("t")).equals("times.")
            && s3.substring(0,s3.indexOf(":")).equals("Ratio")
            && (num1+num2 == times) && (((num1)+0.0)/ (times-num1) == ratio || ((num2+0.0)/times-num2) == ratio));
    }
}
