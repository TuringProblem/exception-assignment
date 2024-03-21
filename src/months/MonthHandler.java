package src.months;
import exception.DayException;
import java.util.Scanner;
import java.util.function.Supplier;

public class MonthHandler {
    public int userInput;
    Scanner KEYBOARD = new Scanner(System.in);
    FebruaryHandler FEB = new FebruaryHandler();
    final String dayExceptionOutput = "Invalid output\n!";
    Supplier<Integer> thirtyOneDays = () -> {
        System.out.println("Please enter a day 1-31: ");
        return KEYBOARD.nextInt();
    };
    public void sendJanuary()throws DayException {
        userInput = thirtyOneDays.get();
        if (thirtyOneDays(userInput)) {

        } else {
            System.out.printf("%s %d%s\n",MonthValidator.MyMonths.JAN.getName(), userInput, FEB.dateCases(userInput) );
        }
    }

    public boolean thirtyOneDays(int userInput)throws DayException {
        if(userInput < 1 || userInput > MonthValidator.MyMonths.JUL.getDays()) {
            System.out.println("SHIT");
            throw new DayException(dayExceptionOutput);
        } else {
            return true;
        }
    }

}