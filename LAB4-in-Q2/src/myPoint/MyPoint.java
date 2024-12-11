package myPoint;

public class MyPoint {
    private double x;
    private double y;

    // No-arg constructor
    public MyPoint() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Parameterized constructor
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Distance to another MyPoint
    public double distance(MyPoint point) {
        return Math.sqrt(Math.pow(this.x - point.getX(), 2) + Math.pow(this.y - point.getY(), 2));
    }

    // Distance to specific coordinates
    public double distance(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create two points
        MyPoint point1 = new MyPoint();
        MyPoint point2 = new MyPoint(10, 30.5);

        // Display distances
        System.out.println("Distance between (0, 0) and (10, 30.5): " + point1.distance(point2));
        System.out.println("Distance between (0, 0) and (5, 12): " + point1.distance(5, 12));
    }
}

