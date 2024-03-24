package src.months;
import exception.DayException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Override
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 * @since 03/18/2024 @14:07
 */

public class FebruaryHandler {
    /**
     * @see MonthHandler -> Grabs the month being passed by the user
     * myDay -> Day value passed by the user
     * Predicate<Integer> leapYearPredicate -> Determines if the year passed is leapyear or not
     * Supplier<Integer> yearSupplier -> Gets the year value from the user
     */
    MonthHandler MONTH = new MonthHandler();
    private int myDay;
    public final String dayPromptNonLeap = "Enter day for February\n EX: [1-28]: ";
    public final String dayPromptLeapYear = "Enter day for leap year\n EX: [1-29]: ";
    public String dayExceptionPrompt = "Invalid Day for February!\n";
    public Scanner KEYBOARD = new Scanner(System.in);
    /**
     * Predicate -> Takes in a value, and returns a boolean result
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">java.util.function</a>
     */
    public final Predicate<Integer> leapYearPredicate = i -> i % 4 == 0 && (i % 100 != 0 || i % 400 == 0);
    public Supplier<Integer> yearSupplier = () -> {
        try {
            System.out.println("Please enter the year: ");
            myDay = KEYBOARD.nextInt();
            if (myDay < 0) {
                System.out.println("Error!\n");
                throw new Exception("Incorrect year!\n I will now close the program!\n");

            } else {
                return myDay;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };
    public boolean isALeapYear() { return leapYearPredicate.test(yearSupplier.get());}//Runs the leap year predicate, returns true if leap year, and false if not

    /**
     * februaryHandler() -> Deals with the output of the month
     * @exception DayException -> If the day is not valid:
     * The user gets one last chance with lastChanceDay();
     */

    public void februaryHandler(MonthValidator.MyMonths monthValue) throws DayException {
        if (isALeapYear()){
            try {
                System.out.println(dayPromptLeapYear);
                myDay = KEYBOARD.nextInt();
                if (myDay < 1 || myDay > 29) {
                    throw new DayException(dayExceptionPrompt);
                } else {
                    MONTH.printOutput(monthValue, myDay);
                }
            } catch (DayException e) {
                System.out.println(e.getMessage());
                lastChanceDay(true);
            }
        } else {
            try {
                System.out.println(dayPromptNonLeap);
                myDay = KEYBOARD.nextInt();
                if (myDay < 1 || myDay > 28) {
                    throw new DayException(dayExceptionPrompt);
                } else {
                    System.out.println(dayPromptNonLeap);
                    MONTH.printOutput(monthValue, myDay);
                }
            } catch (DayException exception) {
                System.out.println(exception.getMessage());
                lastChanceDay(false);
            }
        }
    }

    /**
     * lastChanceDay() -> Checks the users input: if the user inputs incorrectly then the program will close
     * @param leapOrNot -> Checks if the year that was passed was a leap year or not
     */

   public void lastChanceDay(boolean leapOrNot)throws DayException {
        try {
            MonthValidator.MyMonths monthValue = MonthValidator.MyMonths.FEB;
            if (leapOrNot) {
                System.out.println(dayPromptLeapYear);
                myDay = KEYBOARD.nextInt();
                if (myDay < 1 || myDay > 29) {
                    throw new DayException(dayExceptionPrompt);
                } else {
                    MONTH.printOutput(monthValue, myDay);
                }
            } else {
                System.out.println(dayPromptNonLeap);
                myDay = KEYBOARD.nextInt();
                if (myDay < 1 || myDay > 28) {
                    throw new DayException(dayExceptionPrompt);
                } else {
                    MONTH.printOutput(monthValue, myDay);
                }
            }
        } catch (DayException e) {
            System.out.println(e.getMessage());
            seeYa();
        }

    }

    /**
     * Output for kicking the user off
     */

    public void seeYa() {
        System.out.println("I've tried to warn you...\nThis program will now close.\n");
        System.exit(0);
    }
}