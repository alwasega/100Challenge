/**New class that extends CreditCard
 * The class differs from the original in two ways: 
 * (1) If an attempted charge is rejected because it would have exceede the
 * limit, then a 500/- fee is charged. 
 * (2) There will be a mechanism for assessing a monthly charge in the 
 * outstanding balance, using an annual percentage rate (APR) specified 
 * by the customer.
 * The class also adds a new instance variable named apr to store the APR
 * and it overrides the original charge method to provide an implementation
 * for the 500/- fee. Also included is a method named processMethod that 
 * will assess interest charges 
 */
public class ExtendCreditCard{
       /**
	* New instance variable
	* @param apr  variable to store the annual percentage rate
	*/	
	private double apr;

	//constructor
	public ExtendCreditCard(String cust, String bk, String acnt, int lim, double initialBal, double rate){
		super(cust, bk, acnt, lim, initialBal);
		apr = rate;
	}

	//A new method for assessing monthly interest charges
	/**
	 *Method compute monthly interest rate
	* @param monthlyFactor   holds the monthly rate
	*/
       public void processMonth(){
       if(balance>0){
	double monthlyFactor = Math.pow(1 + apr, 1.0/12);
 	balance *= monthlyFactor;
       }
       }

	//Override the charge method defined in the superclass
       public boolean charge(double price){
       boolean isSuccess = super.charge(price) //places a call to the inherited method
	if(!isSuccess){
		balance += 5;}
	return isSuccess;
       }
}       
	 
