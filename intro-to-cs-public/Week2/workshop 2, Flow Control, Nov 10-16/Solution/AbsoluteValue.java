public class AbsoluteValue {

    public static void main(String[] args) {
        int originalValue = Integer.parseInt(args[0]);
        int value = originalValue;
        if (value < 0){
            value *= -1;
        }
        System.out.println("|" + originalValue + "| = " + "value");
    }
}