package src;
import exception.DayException;
import exception.MonthException;


public class MainMethod {
    public static void main(String[] args) throws Exception {
        MonthValidator myMonth = new MonthValidator();
        myMonth.checkMonth();
    }
}

