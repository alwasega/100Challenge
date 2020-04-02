/*
Instances of the Java built-in class, java.util.Random, are pseudorandom number generators, that is they are objects that compuet a sequence of numbers that are statistically random. However, teh next number in the pseudorandom generator is determined by the previous number. Hence, they need a place to start, which is called the seed. The seed for an instance of the java.util.Random class can be set in its constructor or using its setSeed() method. 
Other methods of the class include: 
     nextBoolean: returns the next pseurandom Boolean value
     nextDouble()
     nextInt()
     nextInt(n): returns the next pseudorandom int value in the range from 0 upto but not                           exceeding n
     setSeed(s): Sets the seed of this number generator to the long s.

Because Arrays are so important, Java includes a class, java.util.Arrays, with a number of built-in static methods for performing common tasks on arrays. Some of these methods include: 
       equals(A, B): Returns true only if the arrays A and B are equal i.e. they have the same number of elements and every corresponding pair of elements in teh two arrays are equal.
      fill(A, x): Stores value x in every cell of array A, provided A is defined to be able to store x
     copyOf(A, n):  Returns an array of size n such that the first k elements of this array are copied from A, where k = min(n.A.length). If n>A.length, then the last n-A.length elements in this array will be padded with default values eg 0 for an array of int. 
     copyOfRnage(A, s, t): Returns an array of size t-s.
     toString(A): Returns a String representation of the array A. 
     sort(A): Sorts the array A based on a natural ordering of its elements, which must be comparable
    binarySearch(A, x): Searches the sorted array A for value x.  

*/
import java.util.Random;


public class ArrayTest{
    public static void main (String [] args){
	int data[] = new int[10];
	Random rand = new Random();
	rand.setSeed(System.currentTimeMillis()); //use current system time as a seed

	//fill the data array with pseudo-random numbers from 0 to 99, inclusive

	for(int i =0; i<data.length; i++)
	    data[i] = rand.nextInt(100);

	int[] orig = Arrays.copyOf(data, data.length); //make a copy of the data array

	System.out.println("Arrays equal before sort: "+Arrays.equals(data, orig));
	Arrays.sort(data);//sorting the data array; orig is unchanged

	System.out.println("Arrays equal after sort: "+Arrays.equals(data, orig));

	System.out.println("Original array = : "+Arrays.toString(orig));

	System.out.println("Data array = : "+Arrays.toString(data));

	
    }
}
