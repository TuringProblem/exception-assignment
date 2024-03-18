package exception;

import java.rmi.server.ExportException;

public class DayException extends Exception {

    private int day;
    @SuppressWarnings("unused")
    public DayException() {}
    public DayException(String message) { super(message); }
    public DayException(String message, Exception cause) {super(message, cause);}
}
