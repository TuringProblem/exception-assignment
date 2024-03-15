import java.time.Month;

public class MonthException extends Exception {
    private int month;
    
    MonthException() {
        super();
    }
    MonthException(int month) {
        this.month = month;
    }
}
