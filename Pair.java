//A class that  highlights how Generics in Java work. 
import java.util.Scanner;
public class Pair<T>{
    //instance variables
    private T first;
    private T last;

    //constructors
    public Pair(){
	first = null;
	last = null;
    }

    public Pair(T firstItem, T lastItem){
	first = firstItem;
	last = lastItem;
    }

    //setter methods
    public void setFirst(T newFirst){
	first = newFirst;
    }

     public void setLast(T newLast){
	 last = newLast;
    }

    //getter methods
     public T getFirst(){
	 return first;
    }

     public T getLast(){
	 return last;
    }

    //Output in string
    public String toString(){
	return ("first: " + first.toString() + "\n" + "last: " + last.toString());
    }

    //test for equality 
    public boolean equals(Object otherObject)
    {
	if (otherObject ==null)
	    return false;
	else if (getClass() != otherObject.getClass())
	    return false;
	else
	    {
		Pair<T> otherPair = (Pair<T>)otherObject;
		    return (first.equals(otherPair.first) && last.equals(otherPair.last));
	    }
    }

    //main class
    public static void main (String [] args){
	Pair<String> secretPair = new Pair<> ("Happy", "Day");

	Scanner input = new Scanner(System.in);

	System.out.println("Input two words: ");

	String word1 = input.nextLine();
	String word2 = input.nextLine();

	Pair<String> inputPair = new Pair<>(word1, word2);

	if(inputPair.equals(secretPair))
	    {
		System.out.println("You guessed the secret words in the correct order!");
	    }
	else{
	    System.out.println("You guessed incorrectly.");
	    System.out.println("You guessed");
	    System.out.println(inputPair);
	    System.out.println("The secret words are");
	    System.out.println(secretPair);
	}
    }
}
