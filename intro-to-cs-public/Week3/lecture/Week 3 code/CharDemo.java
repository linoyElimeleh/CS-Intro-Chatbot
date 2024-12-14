public class CharDemo {
    public static void main(String args[]) {
        System.out.println(3);  
        System.out.println('3');
        System.out.println(3 + 1);   // int
        System.out.println('3' + 1); // int
      
        char c = 8096; // sets c to some arbitrary integer
        System.out.println(c); 

        c = 'h';
        System.out.println(c); 
        System.out.println(c - 1);  // int      
       
        // Convert to uppercase
        c = 'd';
        System.out.println(c - 32); // int
        System.out.println((char)(c - 32));  // char

        // Convert to lowercase
        c = 'K';
        // You do it

        // Lowercase check
        c = 't';
        System.out.println((c >= 97) && (c <= 122));  
        System.out.println((c >= 'a') && (c <= 'z'));  // better

        // Digit check 
        c = '7';
        // You do it
    }
}