public class BankAccountDemo {
	public static void main (String args[]) {

		// Creates two bank accounts
	    BankAccount aliceAcc = new BankAccount("Alice");
	    BankAccount bobAcc = new BankAccount("Bob",500);
	    System.out.println(aliceAcc);
	    System.out.println(bobAcc);
	    
	    // Executes some transactions
		aliceAcc.deposit(1000);
	    bobAcc.withdraw(200);
	    bobAcc.deposit(1000);
	    System.out.println(aliceAcc);
	    System.out.println(bobAcc);
	    
	    // Transfers money from Alice to Bob
        aliceAcc.transferTo(bobAcc, 400);
        System.out.println(aliceAcc);
	    System.out.println(bobAcc);
	    System.out.println("The current balance of Bob is " + bobAcc.getBalance());
    }
}