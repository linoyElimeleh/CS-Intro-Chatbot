/** Represents a timer. Features methods for time measurements. */
public class Timer {
    
    // The time at which this timer started running
    private long startTime;
    
    /** Constructs a timer and sets it to the current time. */
    public Timer() {
        reset();
    }
    
    /** Resets this timer to the current time.
     * The current time is the system clock, in nanoseconds. */
    public void reset() {
        startTime = System.nanoTime();
    }
    
    /** Returns how much time elapsed (in milliseconds)
     *  since the last reset of this timer. */
    public double elapsedTime() {
        // Converts nanoseconds to milliseconds
        return (System.nanoTime() - startTime) / 1_000_000.0; 
    }
}