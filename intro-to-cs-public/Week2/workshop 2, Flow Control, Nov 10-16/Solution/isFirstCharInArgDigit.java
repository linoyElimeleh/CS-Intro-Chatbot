public class isFirstCharInArgDigit {
    public static void main(String[] args) {
        char firstCharOfFirstArg = args[0].charAt(0); 
        String digits = "0123456789";
        if (digits.indexOf(firstCharOfFirstArg) != -1){
            System.out.println("The first char is a digit");
        } else {
            System.out.println("The first char isn't a digit");
        }
    }
}
