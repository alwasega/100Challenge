/**
 * Define a Polygon interface that has methods area( ) and perimeter( ). Then im-
 * plement classes for Triangle, Quadrilateral, Pentagon, Hexagon, and Octagon,
 * which implement this interface, with the obvious meanings for the area( ) and
 * perimeter( ) methods. Also implement classes, IsoscelesTriangle, Equilateral-
 * Triangle, Rectangle, and Square, which have the appropriate inheritance rela-
 * tionships. Finally, write a simple user interface, which allows users to create
 * polygons of the various types, input their geometric dimensions, and then out-
 * put their area and perimeter. For extra effort, allow users to input polygons by
 * specifying their vertex coordinates and be able to test if two such polygons are
 * similar.
 */
public interface Polygon{
	//define the methods to be inherited by the implementing classes
	public double findArea();

	public double findPerimeter();
}
