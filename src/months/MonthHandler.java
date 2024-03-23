package src.months;
import exception.DayException;
import java.util.Scanner;
import java.util.function.Supplier;

public class MonthHandler {
    private int userInput;
    Scanner KEYBOARD = new Scanner(System.in);
    FebruaryHandler FEB = new FebruaryHandler();
    MonthValidator MONTH = new MonthValidator();
    final String dayExceptionOutput = "Invalid output!\n";

    Supplier<Integer> thirtyOneDays = () -> {
        System.out.println("Please enter a day 1-31: ");
        return KEYBOARD.nextInt();
    };

    Supplier<Integer> thirtyDays = () -> {
        System.out.println("Please enter a day [1-30]: ");
        return KEYBOARD.nextInt();
    };

    /**
     * @throws DayException -> Checks to make sure the user uses the correct inputs.
     */
    public void setUserInput() {userInput = thirtyOneDays.get();}
    public void setUserInputThirty() {userInput = thirtyDays.get();}

    /**
     * @param month ->
     * @throws DayException
     */

    public void sendResultThirtyOne(int month)throws DayException {
        setUserInput();
        try{
            if (!thirtyoneDays(userInput)) {
                printOutput(month);
            } else {
                throw new DayException(dayExceptionOutput);
            }
        } catch (DayException e ) {
            System.out.println(e.getMessage());
            secondChanceThirtyOneDays(month);
        }
    }

    public void sendResultThirty(int month)throws DayException {
        setUserInputThirty();
        try{
            if (!thirtyDays(userInput)) {
                printOutput(month);
            } else {
                throw new DayException(dayExceptionOutput);
            }
        } catch (DayException e ) {
            System.out.println(e.getMessage());
            secondChanceThirtyDays(month);
        }
    }

    /**
     * @param value -> gives the user one last chance
     */

    public void secondChanceThirtyDays(int value) {
        userInput = thirtyDays.get();
        if (!thirtyDays(userInput)) {
            printOutput(value);
        } else {
            System.out.println("I've tried to warn you...\n goodbye for now!\n");
            System.exit(0);
        }
    }

    public void secondChanceThirtyOneDays(int value) {
        userInput = thirtyOneDays.get();
        if (!thirtyoneDays(userInput)) {
            printOutput(value);
        } else {
            System.out.println("I've tried to warn you...\n goodbye for now!\n");
            System.exit(0);
        }
    }
    public void printOutput(int monthPassed) { System.out.printf("%s %d%s\n", MONTH.caseHandler(monthPassed), userInput, FEB.dateCases(userInput)); }
    public boolean thirtyDays(int userInput) { return  userInput < 1 || userInput > 30; }
    public boolean thirtyoneDays(int userInput) { return userInput < 1 || userInput > 31; }
}
