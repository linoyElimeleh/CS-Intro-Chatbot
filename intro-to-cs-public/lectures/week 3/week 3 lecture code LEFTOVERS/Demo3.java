// Demonstrates that strings are immutable, and arrays are mutable.
public class Demo3 {
    public static void main(String args[]) {

       System.out.println(3);  
       System.out.println('3');
       System.out.println(3 + 1);
       System.out.println('3' + 1); // '3' is cast as int
      
       char c = 8096; // sets c to some arbitrary integer
       System.out.println(c); 

       c = 'h';       // c = 104
       System.out.println(c); 
       System.out.println(c - 1);  // convert to uppercase

      
       // Lowercase check
       c = 'd';
       System.out.println((c >= 97) && (c <= 122));  
       System.out.println((c >= 'a') && (c <= 'z'));  // better

       // Convert to uppercase
       c = 'd';
       System.out.println((char)(c - 32));

       // Convert to lowercase
       c = 'K';
       System.out.println((char)(c + 32)); 

        // Digit check 
       c = '7';
       System.out.println((c >= 48) && (c <= 57));  
       System.out.println((c >= '0') && (c <= '9'));  // better       

/*
       System.out.println(c++); 
       System.out.println(c); 
       System.out.println(c + 1); // c is cast as int
       System.out.println((char) (c + 1));
      
       c = 109;
       System.out.println(c); // c is a char
       a = 109;
       System.out.println(a); // a is an int
      
       c = '8';
       System.out.println(c); // c is a char
       System.out.println(c - 0); // c is cast as int
       System.out.println(c - '0'); // c is cast as int */
   }
}