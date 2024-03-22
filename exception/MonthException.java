package exception;
public class MonthException extends Exception {
    @SuppressWarnings("unused")
    public MonthException() {
        super();
    }
    public MonthException(String message) { super(message); }
}
