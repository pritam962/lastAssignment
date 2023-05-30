
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import java.util.Scanner;

	public class La_10 {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        List<Integer> numbers = new ArrayList<>();

	        System.out.print("Enter the number of elements: ");
	        int count = scanner.nextInt();

	        System.out.println("Enter the elements:");

	        for (int i = 0; i < count; i++) {
	            int number = scanner.nextInt();
	            numbers.add(number);
	        }

	        if (numbers.size() < 2) {
	            System.out.println("List must contain at least 2 elements.");
	            return;
	        }

	        int secondLargest = findSecondLargest(numbers);
	        int secondSmallest = findSecondSmallest(numbers);

	        System.out.println("Second Largest: " + secondLargest);
	        System.out.println("Second Smallest: " + secondSmallest);
	    }

	    public static int findSecondLargest(List<Integer> numbers) {
	        Collections.sort(numbers);
	        return numbers.get(numbers.size() - 2);
	    }

	    public static int findSecondSmallest(List<Integer> numbers) {
	        Collections.sort(numbers);
	        return numbers.get(1);
	    }
	}

