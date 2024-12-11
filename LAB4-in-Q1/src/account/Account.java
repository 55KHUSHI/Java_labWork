package account;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    // No-arg constructor
    public Account() {
        this.id = 0;
        this.balance = 0.0;
        this.annualInterestRate = 0.0;
    }

    // Parameterized constructor
    public Account(int id, double balance, double annualInterestRate) {
        if (id <= 0 || balance < 0 || annualInterestRate < 0) {
            throw new IllegalArgumentException("ID, balance, and interest rate must be positive.");
        }
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    // Calculate monthly interest rate
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12 / 100;
    }

    // Withdraw method
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Deposit method
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create an Account object
        Account account = new Account(1122, 20000, 4.5);

        // Perform transactions
        account.withdraw(2500); // Withdraw $2,500
        account.deposit(3000);  // Deposit $3,000

        // Display results
        System.out.println("Account ID: " + account.getId());
        System.out.println("Balance: $" + account.getBalance());
        System.out.println("Monthly Interest: $" + account.getBalance() * account.getMonthlyInterestRate());
    }
}