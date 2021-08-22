import java.awt.Color;

class ShapeTester {
    public static void main(String[] args) {
        Shape circle1 = new Circle(3, 3, Color.CYAN, 5);
        Shape circle2 = new Circle(6, 6, Color.BLACK, 3);
        Shape circle3 = new Circle(2, 2, Color.GREEN, 14);

        System.out.println(circle1.getArea());
        System.out.println(circle2.getArea());
        System.out.println(circle3.getArea());
    }
}

class Shape {
    private int xLoc;
    private int yLoc;
    // 1) Add an instance variable for Color...
    private Color color;

    public Shape( int xLocation, int yLocation ) {
    	xLoc = xLocation;
    	yLoc = yLocation;
    }

    public int getX() {return xLoc;}

    public int getY() {return yLoc;}

    public Color getColor() {return color;}
    
    /**
     2) Write an alternate constructor that takes the x, y location AND
     	a color object and initializes all instance variables.
    */
    public Shape( int xLocation, int yLocation, Color c ) {
        xLoc = xLocation;
        yLoc = yLocation;
        color = c;
    }

    public double getArea() { return 0; }

} // end class Shape

/** 3) Write a class Circle that has an instance field for radius and
	   inherits the x,y and color from the Shape class. 
      (3b) Write a constructor for Circle that initializes all instance variables,
	   including location.
      (3c) Write a getArea method that returns the area of the circle

*/

class Circle extends Shape {
    private double radius;

    public Circle( int xLocation, int yLocation, Color c ) {
        super(xLocation, yLocation, c);
    }

    public Circle( int xLocation, int yLocation, Color c, double radius) {
        super(xLocation, yLocation, c);
        this.radius = radius;
    }

    public double getArea() {
        double area = radius * radius * Math.PI;
        return area;
    }
}