package myInteger2;

import java.math.BigInteger;

public class MyInteger {
    private int value;

    // Constructor
    public MyInteger(int value) {
        this.value = value;
    }

    // Getter
    public int getValue() {
        return value;
    }

    // Factorial method
    public static BigInteger factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("Factorial of 5: " + MyInteger.factorial(5));
        System.out.println("Factorial of 10: " + MyInteger.factorial(10));
    }
}