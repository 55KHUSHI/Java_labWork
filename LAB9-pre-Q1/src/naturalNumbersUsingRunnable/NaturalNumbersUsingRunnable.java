package naturalNumbersUsingRunnable;

//Class implementing Runnable to print natural numbers
class NaturalNumbersRunnable implements Runnable {
 private final int threadNumber;

 // Constructor
 public NaturalNumbersRunnable(int threadNumber) {
     this.threadNumber = threadNumber;
 }

 // Overriding run() to print natural numbers
 @Override
 public void run() {
     System.out.println("Thread " + threadNumber + " started:");
     for (int i = 1; i <= 5; i++) {
         System.out.println("Thread " + threadNumber + ": " + i);
         try {
             Thread.sleep(100); // Adding slight delay to observe interleaving
         } catch (InterruptedException e) {
             System.out.println("Thread interrupted: " + e.getMessage());
         }
     }
     System.out.println("Thread " + threadNumber + " finished.");
 }
}

public class NaturalNumbersUsingRunnable {
 public static void main(String[] args) {
     // Creating threads
     Thread t1 = new Thread(new NaturalNumbersRunnable(1));
     Thread t2 = new Thread(new NaturalNumbersRunnable(2));
     Thread t3 = new Thread(new NaturalNumbersRunnable(3));

     // Starting threads
     t1.start();
     t2.start();
     t3.start();
 }
}

