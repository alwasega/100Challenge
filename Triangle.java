/**Define a Polygon interface that has methods area( ) and perimeter( ). Then im-
plement classes for Triangle, Quadrilateral, Pentagon, Hexagon, and Octagon,
which implement this interface, with the obvious meanings for the area( ) and
perimeter( ) methods. Also implement classes, IsoscelesTriangle, Equilateral-
Triangle, Rectangle, and Square, which have the appropriate inheritance rela-
tionships. Finally, write a simple user interface, which allows users to create
polygons of the various types, input their geometric dimensions, and then out-
put their area and perimeter. For extra effort, allow users to input polygons by
specifying their vertex coordinates and be able to test if two such polygons are
similar**/
import java.util.Scanner;
public class Triangle implements Polygon{
	//instance variables
	
	private int length;
	private int width;
	private int hypotenuse;
	
	//constructor
	public Triangle(int length, int width, int hypotenuse){
		this.length = length;
		this.width = width;
		this.hypotenuse = hypotenuse;
	}

	//setter methods
	public void setLength(int input_length){
		length = input_length;}

	public void setWidth(int input_width){
		width = input_width;}

	public void setHypotenuse(int hypo){
		hypotenuse = hypo;}

	//getter methods
	public int getLength(){
		return length;}

	public int getWidth(){
		return width;}

	public int getHypotenuse(){
		return hypotenuse;}

	//defining the inherited methods
	
	public double findArea(){
		double area= (0.5*(length * width));
		return area;
	}
	
	
	public double findPerimeter(){
		double perimeter = (length + width + hypotenuse);
		return perimeter;
	}	

	//defining a method to print the results
	public void printResults(){
		System.out.println("The area of the triangle is " + findArea());
		System.out.println("The perimeter of the triangle is "+ findPerimeter());}
	
	//define main method
	public static void main(String [] args){
		
		Scanner input = new Scanner(System.in);

		Triangle poly = new Triangle(6,7,9);

		System.out.println("Input the length of the triangle: ");
		int length = input.nextInt();
		

		System.out.println("Input the width of the triangle: ");
                int width = input.nextInt();

		System.out.println("Input the hypotenuse of the triangle: ");
                int hypotenuse = input.nextInt();
		
		poly.setLength(length);
		poly.setWidth(width);
		poly.setHypotenuse(hypotenuse);
		poly.printResults();


	}
}

