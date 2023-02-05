import java.time.Duration;
import java.time.Instant;

public class StopWatch {

    private Instant start;
    private Instant end;

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

    public String getDuration() {
        if (start == null || end == null){
            throw new IllegalStateException("start or null can't be null");
        }
        Duration duration = Duration.between(start, end);

        long lengthOfTime = duration.getNano() /1000;
        return String.valueOf(lengthOfTime);
    }
}
