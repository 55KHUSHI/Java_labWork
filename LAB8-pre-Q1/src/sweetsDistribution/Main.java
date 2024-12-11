package sweetsDistribution;

class SweetsDistribution {
    private int numberOfSweets;
    private int numberOfChildren;

    // Parameterized Constructor
    public SweetsDistribution(int sweets, int children) {
        this.numberOfSweets = sweets;
        this.numberOfChildren = children;
    }

    // Method to distribute sweets
    public void distribute() {
        try {
            if (numberOfChildren == 0) {
                throw new ArithmeticException("Number of children cannot be zero.");
            }
            int sweetsPerChild = numberOfSweets / numberOfChildren;
            System.out.println("Each child will receive " + sweetsPerChild + " sweets.");
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Case 1: Valid number of children
        SweetsDistribution validCase = new SweetsDistribution(100, 5);
        validCase.distribute();

        // Case 2: Number of children is zero
        SweetsDistribution invalidCase = new SweetsDistribution(100, 0);
        invalidCase.distribute();
    }
}
