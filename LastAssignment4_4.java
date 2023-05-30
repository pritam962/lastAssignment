
	import java.util.Scanner;

	class BankAccount {
	    private double balance;

	    public BankAccount() {
	        balance = 0.0;
	    }

	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("Deposit successful. New balance: " + balance);
	        } else {
	            System.out.println("Invalid amount. Deposit failed.");
	        }
	    }

	    public void withdraw(double amount) {
	        if (amount > 0) {
	            if (balance >= amount) {
	                balance -= amount;
	                System.out.println("Withdrawal successful. New balance: " + balance);
	            } else {
	                System.out.println("Insufficient balance. Withdrawal failed.");
	            }
	        } else {
	            System.out.println("Invalid amount. Withdrawal failed.");
	        }
	    }

	    public double getBalance() {
	        return balance;
	    }
	}

	public class LastAssignment4_4 {
	    public static void main(String[] args) {
	        BankAccount account = new BankAccount();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nBank Account Simulator");
	            System.out.println("1. Deposit");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Check Balance");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter deposit amount: ");
	                    double depositAmount = scanner.nextDouble();
	                    account.deposit(depositAmount);
	                    break;
	                case 2:
	                    System.out.print("Enter withdrawal amount: ");
	                    double withdrawalAmount = scanner.nextDouble();
	                    account.withdraw(withdrawalAmount);
	                    break;
	                case 3:
	                    System.out.println("Current balance: " + account.getBalance());
	                    break;
	                case 4:
	                    System.out.println("Exiting program...");
	                    scanner.close();
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Try again.");
	                    break;
	            }
	        }
	    }
	}
