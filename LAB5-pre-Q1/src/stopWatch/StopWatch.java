package stopWatch;

import java.time.Instant;

public class StopWatch {
    private long startTime;
    private long endTime;

    // No-arg constructor
    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    // Start the stopwatch
    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    // Stop the stopwatch
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    // Get elapsed time in milliseconds
    public long getElapsedTime() {
        return endTime - startTime;
    }

    // Main method to test the class
    public static void main(String[] args) {
        StopWatch stopwatch = new StopWatch();

        // Simulate a process
        stopwatch.start();
        for (int i = 0; i < 1_000_000; i++) {
            // Simulate time-consuming task
        }
        stopwatch.stop();

        System.out.println("Elapsed Time: " + stopwatch.getElapsedTime() + " ms");
    }
}


