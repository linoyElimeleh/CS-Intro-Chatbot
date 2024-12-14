public class IsValidNumber {
    public static void main(String[] args) {
        String digits = "0123456789";
        String stringNumber = args[0];
        boolean isNumber = true;
        for (int i = 0; i < stringNumber.length(); i++){
            char currentChar = stringNumber.charAt(i);
            if (digits.indexOf(currentChar) == -1){
                isNumber = false;
                break;
            }
        }
        if (isNumber){
            System.out.println("The string is a number");
        } else {
            System.out.println("The string isn't a number");
        }
    }
}
