package arrayIndexException;

import java.util.Scanner;

public class ArrayIndexException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        System.out.println("Enter 10 values into the array:");

        // Input 10 values
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        try {
            // Attempt to access the 11th index
            System.out.println("Value at 11th index: " + arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: " + e.getMessage());
            System.out.println("You attempted to access an index that does not exist.");
        }

        sc.close();
    }
}


