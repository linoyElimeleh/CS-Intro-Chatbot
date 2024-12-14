public class IsTwoDigitNumber {
    public static void main(String[] args) {
        int value = Integer.parseInt(args[0]);
        if (value >= 10 && value <= 99){
            System.out.println("The number " + value + " is a two digit number!");
        } else {
            System.out.println("The number " + value + " is not a two digit number!");
        }
    }
}
