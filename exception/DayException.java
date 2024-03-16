package exception;

public class DayException extends Exception {

    private int day;
    @SuppressWarnings("unused")
    public DayException() {}
    public DayException(String message, int day) {
        super("You are unable to use that value");
        this.day = day;
    }
    public DayException(Throwable cause) {
        super(cause);
    }
}
