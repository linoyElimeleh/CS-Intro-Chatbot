/** 
 * Represents a bank account.
 * A bank account has an id, an owner, and a balance. 
 * Note: the methods of this class perform no input checks.
 * @author IDC Intro to CS Staff
 */
public class BankAccount {
	
	private static int nextAccountId = 1;
	
	// The properties of this bank account
	private int id;  
	private String owner;
	private double balance;

	/**
	 * Constructs a new bank account with the given owner and balance.
	 * The account id is a running integer, generated automatically.
	 * The first constructed account has id=1, the second id=2, and so on.
	 * @param owner    Owner of this bank account
	 * @param balance  Initial balance of this account
	 */
	public BankAccount(String owner, double balance) {
        // Calls a helper function to generate a unique id
        this.id = generateId();
        // Assigns the parameter values to the fields of the newly created object
        this.owner = owner;
        this.balance = balance;
    }     

	/**
	 * Constructs a new bank account with the given owner and a zero balance.
	 * The account id is a running integer, generated automatically.
	 * The first constructed account has id=1, the second id=2, and so on.
	 * @param owner    Owner of this bank account
	 */
	public BankAccount(String owner) {
		this(owner, 0);
	}

	/**
	 * Returns a textual representation of this bank account.
	 * @return this bank account's id, owner, and balance, as a string
	 */
	public String toString() {
		return (id + " " + owner + " " + balance);
	}

	/**
	 * Returns the balance of this bankAccount.
	 * @return the balance of this bankAccount.
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets the balance of this bankAccount.
	 * @param balance the new balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Returns the id of this bankAccount.
	 * @return the id of this bankAccount.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the owner of this bankAccount.
	 * @return the owner of this bankAccount.
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Handles a deposit.
	 * Modifies the balance of this bank account.
	 * @param sum  To be added to this account's balance 
	 */
	public void deposit(double sum) {
		balance = balance + sum;
	}
	
	/**
	 * Handles a withdrawl.
	 * Modifies the balance of this bank account.
	 * @param sum   To be deducted from this account's balance
	 */
	public void withdraw(double sum) {
		balance = balance - sum;
	}
	
	/**
	 * Handles a transfer of money from this bank account to the other bank account.
	 * Modifies the account balances of both accounts.
	 * @param sum     To be added to the balance of the other account 
	 * @param other   To be deducted from the balance of this account 
	 */
	public void transferTo(BankAccount other, double sum) {
	    other.deposit(sum);
	    this.withdraw(sum);
	}
	
	// Helper function.
	// Generates an account id. Used by the class constructors.
	private static int generateId() {
		return nextAccountId++;
	}
}