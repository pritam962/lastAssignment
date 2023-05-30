
	class Parent {
	    public Parent() {
	        System.out.println("Parent class constructor invoked");
	    }
	}

	class Child extends Parent {
	    public Child() {
	        super(); // Invoking parent class constructor
	        System.out.println("Child class constructor invoked");
	    }
	}

	public class LastAssignment2_2{
	    public static void main(String[] args) {
	        Child child = new Child();
	    }
	}

//Constructors are special methods in a class that are used to initialize objects of that class.
//Constructors have the same name as the class and do not have a return type, not even void.
//Constructors are called automatically when an object is created using the new keyword.
//If a constructor is not explicitly defined in a class, a default constructor (with no parameters) is provided by the Java compiler.
//If a class extends another class, the child class constructor must invoke the parent class constructor using the super() keyword. This ensures that the parent class is properly initialized before the child class.
//If a child class constructor does not explicitly call the parent class constructor using super(), the compiler automatically inserts a call to the parent class's default constructor.
//Constructors can be overloaded, meaning a class can have multiple constructors with different parameter lists. This allows for object initialization with different sets of values.
//Constructors can also have access modifiers (e.g., public, private, protected) to control their visibility.
//Constructors can contain initialization code, assignments, and method calls needed to set up the object state.
//Constructors cannot be called directly from other methods; they are only called implicitly when creating objects.
