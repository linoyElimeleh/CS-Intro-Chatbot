/** Times various operations on my computer. */
public class TimeOps {
	
    public static void main(String args[]) {
        int sum = 0;
        double d = 1.618;
        BankAccount bobAcct = new BankAccount("bob");

        // Constructs a timer 
        Timer timer = new Timer();

        for (int i = 0 ; i < 1000000000 ; i++) {
            // Do nothing   
            /// Uncomment the operation you wish to time,
            /// re-compile, and execute.                             
            /// sum = sum + i;                            
            /// d = 1.0 / d; 
            /// bobAcct.deposit(i);                             
          	/// BankAccount b = new BankAccount("Bla",i); 
            /// Fraction f = new Fraction(i,i+1); 
            /// d = Math.random();                        
            /// System.out.println(i);                    
        }
        
        // Prints how much time (in milliseconds) the loop ran
        System.out.println("Duration in ms: " + timer.elapsedTime());
    }
}