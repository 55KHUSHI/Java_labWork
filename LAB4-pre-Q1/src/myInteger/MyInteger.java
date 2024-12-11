package myInteger;

public class MyInteger {
    private int value;

    // Constructor
    public MyInteger(int value) {
        this.value = value;
    }

    // Getter for value
    public int getValue() {
        return value;
    }

    // Instance methods
    public boolean isEven() {
        return value % 2 == 0;
    }

    public boolean isOdd() {
        return value % 2 != 0;
    }

    public boolean isPrime() {
        if (value <= 1) return false;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        return true;
    }

    // Static methods
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static boolean isOdd(int num) {
        return num % 2 != 0;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean isEven(MyInteger myInt) {
        return myInt.isEven();
    }

    public static boolean isOdd(MyInteger myInt) {
        return myInt.isOdd();
    }

    public static boolean isPrime(MyInteger myInt) {
        return myInt.isPrime();
    }

    // Equality methods
    public boolean equals(int num) {
        return value == num;
    }

    public boolean equals(MyInteger myInt) {
        return value == myInt.value;
    }

    // Parsing methods
    public static int parseInt(char[] chars) {
        return Integer.parseInt(new String(chars));
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }

    // Main method for testing
    public static void main(String[] args) {
        MyInteger myInt = new MyInteger(29);

        System.out.println("Value: " + myInt.getValue());
        System.out.println("Is Even: " + myInt.isEven());
        System.out.println("Is Odd: " + myInt.isOdd());
        System.out.println("Is Prime: " + myInt.isPrime());

        System.out.println("Static isPrime(29): " + MyInteger.isPrime(29));
        System.out.println("Equals 29: " + myInt.equals(29));

        char[] charArray = {'1', '2', '3'};
        System.out.println("Parse char[]: " + MyInteger.parseInt(charArray));

        System.out.println("Parse String: " + MyInteger.parseInt("456"));
    }
}