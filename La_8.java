
	public class La_8 {
	    public static void main(String[] args) {
	        // Creating thread for even numbers
	        Thread evenThread = new Thread(new EvenNumberRunnable());
	        evenThread.start();

	        // Creating thread for odd numbers
	        Thread oddThread = new Thread(new OddNumberRunnable());
	        oddThread.start();
	    }
	}

	class EvenNumberRunnable implements Runnable {
	    @Override
	    public void run() {
	        for (int i = 2; i <= 10; i += 2) {
	            System.out.println("Even: " + i);

	            try {
	                Thread.sleep(500); // Pause for better visibility
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

	class OddNumberRunnable implements Runnable {
	    @Override
	    public void run() {
	        for (int i = 1; i <= 10; i += 2) {
	            System.out.println("Odd: " + i);

	            try {
	                Thread.sleep(500); // Pause for better visibility
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
