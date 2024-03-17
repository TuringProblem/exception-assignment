package exception;

public class MonthException extends Exception {
    public MonthException() {
        super();
    }
    public MonthException(String message) { super(message); }
    public MonthException(String message, Throwable cause) { super(message, cause); }
}
