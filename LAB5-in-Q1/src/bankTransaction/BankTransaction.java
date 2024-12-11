package bankTransaction;

//Singleton Account Class
class Account {
 private double balance;
 private static final Account instance = new Account();  // Early Instantiation

 // Private constructor to prevent instantiation
 private Account() {
     balance = 1000.0; // Initial balance
 }

 // Public method to get the instance
 public static Account getInstance() {
     return instance;
 }

 // Methods for withdrawing and depositing money
 public synchronized void deposit(double amount) {
     balance += amount;
     System.out.println("Deposited: " + amount);
 }

 public synchronized void withdraw(double amount) {
     if (balance >= amount) {
         balance -= amount;
         System.out.println("Withdrawn: " + amount);
     } else {
         System.out.println("Insufficient funds.");
     }
 }

 // Method to get the current balance
 public synchronized double getBalance() {
     return balance;
 }
}

//ATM class for simulating ATM transactions
class ATM {
 private Account account;

 public ATM() {
     account = Account.getInstance();  // Get the Singleton account instance
 }

 public void depositMoney(double amount) {
     account.deposit(amount);
 }

 public void withdrawMoney(double amount) {
     account.withdraw(amount);
 }

 public void checkBalance() {
     System.out.println("Current Balance: " + account.getBalance());
 }
}

//Main class to test the functionality
public class BankTransaction {
 public static void main(String[] args) {
     ATM atm1 = new ATM();  // First ATM
     ATM atm2 = new ATM();  // Second ATM

     // Simulating transactions
     atm1.depositMoney(500.0);  // ATM 1 deposits
     atm2.withdrawMoney(300.0); // ATM 2 withdraws
     atm1.checkBalance();  // Checking balance after transactions

     // ATM 1 withdraws money
     atm1.withdrawMoney(200.0);
     atm1.checkBalance();
 }
}
