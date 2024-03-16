package exception;

public class MonthException extends Exception {
    private int month;
    
    public MonthException() {
        super();
    }
    public MonthException(String message, int month) {
        super("Unable to use that value\nMake sure that your value is [1-12][January-December]");
        this.month = month;
    }
}
