
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Random;

	public class La_9{
	    public static void main(String[] args) {
	        Queue<Integer> queue = new LinkedList<>();
	        int maxSize = 5;

	        Thread producerThread = new Thread(new Producer(queue, maxSize));
	        Thread consumerThread = new Thread(new Consumer(queue, maxSize));

	        producerThread.start();
	        consumerThread.start();
	    }
	}

	class Producer implements Runnable {
	    private Queue<Integer> queue;
	    private int maxSize;

	    public Producer(Queue<Integer> queue, int maxSize) {
	        this.queue = queue;
	        this.maxSize = maxSize;
	    }

	    @Override
	    public void run() {
	        Random random = new Random();

	        while (true) {
	            synchronized (queue) {
	                while (queue.size() == maxSize) {
	                    try {
	                        queue.wait();
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }

	                int number = random.nextInt(100);
	                System.out.println("Produced: " + number);
	                queue.add(number);

	                queue.notifyAll();
	            }
	        }
	    }
	}

	class Consumer implements Runnable {
	    private Queue<Integer> queue;
	    private int maxSize;

	    public Consumer(Queue<Integer> queue, int maxSize) {
	        this.queue = queue;
	        this.maxSize = maxSize;
	    }

	    @Override
	    public void run() {
	        while (true) {
	            synchronized (queue) {
	                while (queue.isEmpty()) {
	                    try {
	                        queue.wait();
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }

	                int sum = 0;
	                while (!queue.isEmpty()) {
	                    int number = queue.poll();
	                    sum += number;
	                    System.out.println("Consumed: " + number);
	                }

	                System.out.println("Sum: " + sum);

	                queue.notifyAll();
	            }
	        }
	    }
	}
