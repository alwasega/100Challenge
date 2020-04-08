/*NOTES
Inner classes are classes defined within other classes. They are mostly used as helping classes.
Thedefinition of an inner classtakes the following format:

public class OuterClass
{
    private class InnerClass
    {
	//Declarations of InnerClass Instance Variables
	//Definitions of InneClass Methods
    }

    //Declarations of OuterClass Instance Variables
    //Definitions of OuterClass Methods
}
Note that the definition of the inner class need not to be the first item(s) of the outer class, but it is good to place them first/ last so that theyr are easy to find.

    An inner class definition is a member of the outer class in the same way that the instance variables and methods of the outer class are members of the outer class. Thus, an inner class definition is local to the outer class definition. If the inner class is private, then it cannot be accessed by name outside the definition of the outer class.  

There are two advantages to inner classes: First, because they are defined within a class, they can be used to make the outer clas self-contained. Second, both inner and outer classes have access to each other's private methods and private instance variables. 

Java follows this convention: If a method is invoked in an inner clas and the inner class has no such method, then it is assumed to be an invocation of the method by that name in the outer class. Error if this is not the case.To reverse the situation ie invoking a method of the inner class from the outer class is not so simple. To invoke a nonstatic method of the inner class from within a method of the outer class, you need an object of the inner class to use as a calling object. 

**Example, bank account class wth an inner class for amounts of money. 
    */
public class InnerClass
{
    //Defining the inner class
    private class Money
    {
	private long shillings;
	private int cents;

	//Constructor
	public Money(String stringAmount)
	{
	    abortOnNull(stringAmount);
	    int length = stringAmount.length();
	    shillings = Long.parseLong(stringAmount.substring(0, length-3));
	    cents = Integer.parseInt(stringAmount.substring(length-2, length));
	}

	public String getAmount()
	{
	    if (cents >9)
		return (shillings + "." + cents);
	    else
		return (shillings + ".0" + cents);
	}

	public void addIn (Money secondAmount)
	{
	    abortOnNull(secondAmount);
	    int newCents = (cents + secondAmount.cents)%100;
	    long carry = (cents + secondAmount.cents)/100;
	    cents = newCents;
	    shillings = shillings + secondAmount.shillings + carry;
	}

	private void abortOnNull (Object o)
	{
	    if (o == null)
		{
		    System.out.println("Unexpected null argument.");
		    System.exit(0);
		}
	}
    }//end of definition of inner class

    //beginning of definition of outer class
    private Money balance;

    public InnerClass()
    {
	balance = new Money("0.00");//to invoke a nonstatic method of the inner class outside the inner class, you need to create an object of the inner class
    }

    public String getBalance()
    {
	return balance.getAmount();
    }

    public void makeDeposit (String depositAmount)
    {
	balance.addIn(new Money(depositAmount));
    }

    public void closeAccount()
    {
	balance.shillings = 0;
	balance.cents = 0;     //note that the outer class has access to the private instance variables of the inner class
	
    }

    //main method
    public static void main (String[] args)
    {
	System.out.println("Creating a new bank account: ");
	InnerClass account = new InnerClass();
	System.out.println("Account balance now = KSh. "+ account.getBalance());

	System.out.println("Depositing Sh. 500");
	account.makeDeposit("500.00");
	System.out.println("Account balance now = KSh. "+ account.getBalance());

	System.out.println("Depositing Sh. 100.99");
	account.makeDeposit("100.99");
	System.out.println("Account balance now = KSh. "+ account.getBalance());

	System.out.println("Closing account.");
	account.closeAccount();
	System.out.println("Account balance now = KSh. "+ account.getBalance());
    }
}
