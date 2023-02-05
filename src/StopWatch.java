import java.time.Duration;
import java.time.Instant;

/**
 * Basic class for timing stuff. Uses two Java Instance objects and checks the duration between them
 */
public class StopWatch {

    private Instant start;
    private Instant end;
    private static final int NANO_TO_MICRO = 1000;

    public StopWatch() {
        start = null;
        end = null;
    }

    public void start() {
        start = Instant.now();
    }

    public void end() {
        end = Instant.now();
    }

    public void reset() {
        start = null;
        end = null;
    }

    /**
     * Function for getting the time between the start and end instances and returning it as a string
     *
     * @return a string with the timed duration in microseconds
     */
    public String getDuration() {
        if (start == null || end == null) {
            throw new IllegalStateException("start or null can't be null");
        }
        Duration duration = Duration.between(start, end);

        long lengthOfTime = duration.getNano() / NANO_TO_MICRO; // convert nanos to microseconds
        return String.valueOf(lengthOfTime);
    }
}
