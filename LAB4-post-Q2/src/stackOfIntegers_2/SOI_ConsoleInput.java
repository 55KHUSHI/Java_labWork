package stackOfIntegers_2;

import java.util.Scanner;

class SOI_ConsoleInput {
    private int[] elements; // Array to hold the stack elements
    private int size;       // Tracks the size of the stack

    // No-arg constructor
    public SOI_ConsoleInput() {
        this.size = 0;                 // Initialize size to 0
        this.elements = new int[10];   // Default capacity is 10
    }

    // Constructor with specified capacity
    public SOI_ConsoleInput(int capacity) {
        this.size = 0;                 // Initialize size to 0
        this.elements = new int[capacity]; // Create array with given capacity
    }

    // Method to check if the stack is empty
    public boolean empty() {
        return size == 0;
    }

    // Method to return the top element without removing it
    public int peek() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return elements[size - 1];
    }

    // Method to push an element onto the stack
    public void push(int value) {
        if (size >= elements.length) {
            // Resize the array when the capacity is exceeded
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = value;
    }

    // Method to pop an element from the stack
    public int pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return elements[--size];
    }

    // Method to get the current size of the stack
    public int getSize() {
        return size;
    }

    // Main method to test the class with console input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SOI_ConsoleInput stack = new SOI_ConsoleInput();
        int choice;

        System.out.println("Stack Operations:");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Peek");
        System.out.println("4. Get Size");
        System.out.println("5. Check if Empty");
        System.out.println("6. Exit");

        while (true) {
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Push
                    System.out.print("Enter a value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    System.out.println(value + " pushed to the stack.");
                    break;

                case 2: // Pop
                    try {
                        int poppedValue = stack.pop();
                        System.out.println("Popped value: " + poppedValue);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3: // Peek
                    try {
                        int topValue = stack.peek();
                        System.out.println("Top value: " + topValue);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4: // Get Size
                    System.out.println("Current stack size: " + stack.getSize());
                    break;

                case 5: // Check if Empty
                    System.out.println("Is stack empty? " + stack.empty());
                    break;

                case 6: // Exit
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
