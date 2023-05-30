
	import java.util.Scanner;

	public class LastAssignment3_3 {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        try {
	            System.out.print("Enter an integer: ");
	            int number = scanner.nextInt();

	            if (number < 0) {
	                throw new IllegalArgumentException("Number cannot be negative");
	            }

	            System.out.println("Number entered: " + number);
	        } catch (IllegalArgumentException e) {
	            System.out.println("Exception caught: " + e.getMessage());
	        } finally {
	            scanner.close();
	        }
	    }
	}
//In this program, we use a Scanner object to take input from the user. The program prompts the user to enter an integer and stores it in the number variable.
//Inside the try block, we check if the number is negative (number < 0). If it is negative, we throw an IllegalArgumentException with a custom error message using the throw keyword.
//In the catch block, we catch the IllegalArgumentException and handle it by printing the exception message. This allows us to gracefully handle the exception and provide feedback to the user.
//The finally block is used to ensure that the Scanner object is closed, regardless of whether an exception occurs or not.
