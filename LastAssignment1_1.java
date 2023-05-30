
	interface Shape {
	    double calculateArea();
	    double calculatePerimeter();
	}

	class Circle implements Shape {
	    private double radius;

	    public Circle(double radius) {
	        this.radius = radius;
	    }

	    @Override
	    public double calculateArea() {
	        return Math.PI * radius * radius;
	    }

	    @Override
	    public double calculatePerimeter() {
	        return 2 * Math.PI * radius;
	    }
	}

	class Triangle implements Shape {
	    private double side1;
	    private double side2;
	    private double side3;

	    public Triangle(double side1, double side2, double side3) {
	        this.side1 = side1;
	        this.side2 = side2;
	        this.side3 = side3;
	    }

	    @Override
	    public double calculateArea() {
	        double s = (side1 + side2 + side3) / 2; // Calculate semi-perimeter
	        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	    }

	    @Override
	    public double calculatePerimeter() {
	        return side1 + side2 + side3;
	    }
	}

	public class LastAssignment1_1{
	    public static void main(String[] args) {
	        Shape circle = new Circle(5);
	        System.out.println("Circle Area: " + circle.calculateArea());
	        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());

	        Shape triangle = new Triangle(3, 4, 5);
	        System.out.println("Triangle Area: " + triangle.calculateArea());
	        System.out.println("Triangle Perimeter: " + triangle.calculatePerimeter());
	    }
	}


