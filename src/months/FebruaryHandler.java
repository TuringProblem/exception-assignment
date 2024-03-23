package src.months;
import exception.DayException;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 * @author Override
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 * @since 03/18/2024 @14:07
 */

public class FebruaryHandler {
    MonthValidator month = new MonthValidator();

    /**
     * Leap day, is private value used
     */

    private int myDay;
    public final String dayPromptNonLeap = "Enter day for February\n EX: [1-28]: ";
    public final String dayPromptLeapYear = "Enter day for leap year\n EX: [1-29]: ";
    public String dayExceptionPrompt = "Invalid Day for February!\n";
    public Scanner KEYBOARD = new Scanner(System.in);

    public void expectedOutput(int valuePassed) {
        System.out.printf("%s %d%s\n", month.caseHandler(valuePassed), myDay, month.dateCases(myDay));
    }

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

    /**
     * This is the last resort for the user to implement the right value
     */

    public void februaryHandler(int monthValue) {
        if (month.leapYearPredicate.test(yearSupplier.get())) {
            try {
                System.out.println(dayPromptLeapYear);
                myDay = KEYBOARD.nextInt();
                if (myDay < 1 || myDay > 29) {
                    throw new DayException(dayExceptionPrompt);
                } else {
                    expectedOutput(monthValue);
                }
            } catch (DayException e) {
                System.out.println(e.getMessage());
                finalDay(true);
            }
        } else {
            try {
                System.out.println(dayPromptNonLeap);
                myDay = KEYBOARD.nextInt();
                if (myDay < 1 || myDay > 28) {
                    throw new DayException(dayExceptionPrompt);
                }
            } catch (DayException exception) {
                System.out.println(exception.getMessage());
                finalDay(false);
            }
            System.out.println(dayPromptNonLeap);
            expectedOutput(monthValue);
        }
    }

    public void finalDay(boolean leapOrNot) {
        try {
            if (leapOrNot) {
                System.out.println(dayPromptLeapYear);
                myDay = KEYBOARD.nextInt();
                if (myDay < 1 || myDay > 29) {
                    throw new DayException(dayExceptionPrompt);
                } else {
                    expectedOutput(2);
                }
            } else {
                if (myDay < 1 || myDay > 28) {
                    throw new DayException(dayExceptionPrompt);
                } else {
                    expectedOutput(2);
                }
            }
        } catch (DayException e) {
            System.out.println(e.getMessage());
            seeYa();
        }

    }

    public void seeYa() {
        System.out.println("I've tried to warn you...\ngood bye :)");
        System.exit(0);
    }



}
