package atm;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create 10 accounts with ID 1-10 and initial balance of $100
        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i + 1, 100, 0);
        }

        while (true) {
            // Prompt for user ID
            System.out.print("Enter account ID (0 to exit): ");
            int id = scanner.nextInt();
            if (id == 0) {
                System.out.println("Exiting ATM system. Goodbye!");
                break;
            }

            // Validate ID
            if (id < 1 || id > 10) {
                System.out.println("Invalid ID. Please try again.");
                continue;
            }

            Account account = accounts[id - 1];

            // ATM Menu
            while (true) {
                System.out.println("\nATM Menu:");
                System.out.println("1. View Balance");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Deposit Money");
                System.out.println("4. Exit Menu");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1: // View balance
                        System.out.println("Balance: $" + account.getBalance());
                        break;

                    case 2: // Withdraw money
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        if (account.withdraw(withdrawAmount)) {
                            System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
                        } else {
                            System.out.println("Insufficient funds or invalid amount.");
                        }
                        break;

                    case 3: // Deposit money
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        if (account.deposit(depositAmount)) {
                            System.out.println("Deposit successful. New balance: $" + account.getBalance());
                        } else {
                            System.out.println("Invalid deposit amount.");
                        }
                        break;

                    case 4: // Exit menu
                        System.out.println("Exiting menu...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }

                if (choice == 4) break;
            }
        }

        scanner.close();
    }
}

// Account class (use the previous implementation)
class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}

