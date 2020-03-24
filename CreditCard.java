/**
 * A java class that defines and uses credit card objects that model a simplified
 * version of traditional credit card. 
 * They store information about the customer, issuing bank, account identifier, credit limit, and current balance. 
 * They do not charge interest or late payments, but they do restrict charges that would cause a card's balance to go over its credit limits.
 *
 * @author Alwasega
 */
public class CreditCard{
	//Declare the instance variables;
	private String customer_name;
	private String bank_name;
	private String account_id;
	private int limit;
	private double balance;
	//Constructor
	/**
	 * Constructs a new credit card instance
	 * @param customer_name    the name of the customer
	 * @param bank_name        the name of the issuing bank
	 * @param account_id       the account identifier
	 * @param limit    	   the credit limit of the customer
	 * @param balance          the balance in the card
	 */
	public CreditCard(String cust, String bk, String acnt, int lim, double initBal){
		customer_name = cust;
		bank_name = bk;
		account_id = acnt;
		limit = lim;
		balance = initBal;}

	public CreditCard(String cust, String bk, String acnt, int lim){
		this(cust, bk, acnt, lim, 0.0);}
	//methods
	
	//Accessor methods
	public String getCustomer_name(){return customer_name;}
	public String getBank_name(){return bank_name;}
	public String getAccount_id(){return account_id;}
	public int getLimit(){return limit;}
	public double getBalance(){return balance;}

	/**
	 * Charges the given price to the card, assuming sufficient credit limit
	 * @param price   the amount to be charged
	 * @return true   if charge was accepted; false if charge was denied
	 *
	 */
	public boolean charge(double price){       //method to make a charge
		if (price+ balance>limit)
			return false;//deny the charge if limit is exceeded
		balance += price; //update the balance
		return true;}
	
	/**
	 * Processes customer payment that reduces the balance.
	 * @param amount   the amount of payment that is made
:	 */
	public void makePayment(double amount){    //method to make a payment
		balance -= amount;
	}

	//Utility method to print card details
	public static void printSummary(CreditCard card){
		System.out.println("Customer = " + card.customer_name);

		System.out.println("Bank = " + card.bank_name);
		System.out.println("Account = " + card.account_id);
		System.out.println("Balance = " + card.balance);
		System.out.println("Limit = " + card.limit);
		
	}


	//main method
	public static void main(String [] args){
		CreditCard[] wallet = new CreditCard[3];
		wallet[0] = new CreditCard("Allan Wasega", "KCB", "234 455 344", 10000);
		wallet[1] = new CreditCard("Allan Wasega", "Barclays", "234 466 355", 20000);
		wallet[2] = new CreditCard("Allan Wasega", "Standard Chartered", "256 488 366", 30000, 200);

	for (int val =1; val<=16; val++){
		wallet[0].charge(3*val);
		wallet[1].charge(2*val);
		wallet[2].charge(val);
	}


	for (CreditCard card : wallet){
		CreditCard.printSummary(card);
		while (card.getBalance() >200.0){
			card.makePayment(200);
			System.out.println("New balance = " + card.getBalance());
			System.out.println();
		}
	}
	}

}







