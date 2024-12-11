package primeCompositeNumbers;
import java.util.Scanner;

//Thread to calculate prime numbers
class PrimeThread extends Thread {
 private int limit;
 private StringBuilder primeNumbers = new StringBuilder();

 public PrimeThread(int limit) {
     this.limit = limit;
 }

 @Override
 public void run() {
     for (int i = 2; i <= limit; i++) {
         if (isPrime(i)) {
             primeNumbers.append(i).append(" ");
         }
     }
 }

 private boolean isPrime(int num) {
     if (num <= 1) return false;
     for (int i = 2; i <= Math.sqrt(num); i++) {
         if (num % i == 0) return false;
     }
     return true;
 }

 public String getPrimeNumbers() {
     return primeNumbers.toString();
 }
}

//Thread to calculate composite numbers
class CompositeThread extends Thread {
 private int limit;
 private StringBuilder compositeNumbers = new StringBuilder();

 public CompositeThread(int limit) {
     this.limit = limit;
 }

 @Override
 public void run() {
     for (int i = 2; i <= limit; i++) {
         if (!isPrime(i)) {
             compositeNumbers.append(i).append(" ");
         }
     }
 }

 private boolean isPrime(int num) {
     if (num <= 1) return false;
     for (int i = 2; i <= Math.sqrt(num); i++) {
         if (num % i == 0) return false;
     }
     return true;
 }

 public String getCompositeNumbers() {
     return compositeNumbers.toString();
 }
}

public class PrimeCompositeNumbers {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.print("Enter the limit: ");
     int limit = sc.nextInt();

     // Create threads
     PrimeThread primeThread = new PrimeThread(limit);
     CompositeThread compositeThread = new CompositeThread(limit);

     // Start threads
     primeThread.start();
     compositeThread.start();

     // Wait for threads to complete
     try {
         primeThread.join();
         compositeThread.join();
     } catch (InterruptedException e) {
         System.out.println("Thread interrupted: " + e.getMessage());
     }

     // Print results in a formatted way
     System.out.println("Prime Numbers:");
     System.out.println(primeThread.getPrimeNumbers());
     System.out.println("Composite Numbers:");
     System.out.println(compositeThread.getCompositeNumbers());

     sc.close();
 }
}
