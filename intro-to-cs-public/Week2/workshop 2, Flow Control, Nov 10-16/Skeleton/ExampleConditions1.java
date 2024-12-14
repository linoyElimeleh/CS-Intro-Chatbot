public class ExampleConditions1 {
      public static void main(String[] args) {
        int count = 50;
        if (count < 80) {
            System.out.println(count + " is less than 80");
        }
        if (count < 100) {
            System.out.println(count + " is less than 80");
        }
        System.out.println();
        System.out.println("**************************");
        System.out.println("**************************");
        System.out.println();
        if (count < 80) {
            System.out.println(count + " is less than 80");
        } else if (count < 100) {
            System.out.println(count + " is less than 100");
        } 
    }  
}