import java.time.LocalDateTime;

public class SmartLogger implements Logger {
    private int counter = 0;

    @Override
    public void log(String msg) {
        counter++;
        String logLevel = "INFO";
        if (msg.toLowerCase().contains("error")) {
            logLevel = "ERROR";
        }
        System.out.println(logLevel + "#" + counter + " [" + LocalDateTime.now() + "] " + msg);
    }
}
