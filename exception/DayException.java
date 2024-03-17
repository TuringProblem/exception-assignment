package exception;

public class DayException extends Exception {

    private int day;
    @SuppressWarnings("unused")
    public DayException() {}
    public DayException(String message, Throwable cause) { super(message, cause); }
}
