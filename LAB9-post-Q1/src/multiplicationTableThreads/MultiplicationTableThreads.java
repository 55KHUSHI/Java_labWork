package multiplicationTableThreads;

import java.util.Scanner;

//Class to print multiplication table using synchronized block
class MultiplicationTable {
 public void printTable(int number) {
     synchronized (this) {
         System.out.println("Multiplication Table for: " + number);
         for (int i = 1; i <= 10; i++) {
             System.out.println(number + " x " + i + " = " + (number * i));
             try {
                 Thread.sleep(100); // Adding delay to simulate real-time processing
             } catch (InterruptedException e) {
                 System.out.println("Thread interrupted: " + e.getMessage());
             }
         }
         System.out.println("-----------------------------");
     }
 }
}

//Thread to print table of the first number
class TableThread1 extends Thread {
 private int number;
 private MultiplicationTable table;

 public TableThread1(int number, MultiplicationTable table) {
     this.number = number;
     this.table = table;
 }

 @Override
 public void run() {
     table.printTable(number);
 }
}

//Thread to print table of the second number
class TableThread2 extends Thread {
 private int number;
 private MultiplicationTable table;

 public TableThread2(int number, MultiplicationTable table) {
     this.number = number;
     this.table = table;
 }

 @Override
 public void run() {
     table.printTable(number);
 }
}

public class MultiplicationTableThreads {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // Input numbers
     System.out.print("Enter the first number: ");
     int num1 = sc.nextInt();
     System.out.print("Enter the second number: ");
     int num2 = sc.nextInt();

     // Shared resource for synchronization
     MultiplicationTable table = new MultiplicationTable();

     // Create threads
     TableThread1 thread1 = new TableThread1(num1, table);
     TableThread2 thread2 = new TableThread2(num2, table);

     // Start threads
     thread1.start();
     thread2.start();

     // Wait for threads to complete
     try {
         thread1.join();
         thread2.join();
     } catch (InterruptedException e) {
         System.out.println("Main thread interrupted: " + e.getMessage());
     }

     System.out.println("Multiplication tables printed successfully.");
     sc.close();
 }
}
