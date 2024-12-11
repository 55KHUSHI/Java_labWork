package stackOfIntegers;

class StackOfIntegers {
    private int[] elements; // Array to hold the stack elements
    private int size;       // Tracks the size of the stack

    // No-arg constructor
    public StackOfIntegers() {
        this.size = 0;                 // Initialize size to 0
        this.elements = new int[10];   // Default capacity is 10
    }

    // Constructor with specified capacity
    public StackOfIntegers(int capacity) {
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

    // Main method to test the class
    public static void main(String[] args) {
        StackOfIntegers stack = new StackOfIntegers();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display stack operations
        System.out.println("Peek: " + stack.peek());  // Output: 30
        System.out.println("Pop: " + stack.pop());    // Output: 30
        System.out.println("Size: " + stack.getSize()); // Output: 2
        System.out.println("Empty: " + stack.empty()); // Output: false
    }
}
