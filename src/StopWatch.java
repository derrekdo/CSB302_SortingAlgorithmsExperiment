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

        Duration duration = Duration.between(start, end);

        return duration.toString();
    }
}
