import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList1{
    public static void main (String [] args){
	//creating the ArrayList Object
	ArrayList<String> toDoList = new ArrayList<>(20); //object  toDoList is of initial size 20

	Scanner input = new Scanner(System.in);
	
	System.out.println("When promted, enter list entries ");

	boolean done = false;
	String next = null;
	String answer;

	while (!done)
	    {
		System.out.println("Input an entry");
		next = input.nextLine();
		toDoList.add(next);//adding the input entry to the toDoList

		System.out.println("More items to the List?" );
		answer = input.nextLine();
		if(!(answer.equalsIgnoreCase("yes")))
		    done =true;
		
		System.out.println("The list contains: " );
		for (String entry : toDoList)
		    System.out.println(entry);
		        
		    
	    }

	
    }
}
