package src;
import exception.DayException;
import java.time.MonthDay;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * @auther -> Override
 * @since 03/18/2024 @14:07
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 */

public class FebruaryHandler {
    MonthValidator month = new MonthValidator();

    /**
     * Creating  {@link #leapDay} ->
     */
    private int leapDay;
    public String dayPromptLeap = "Incorrect value\n Please enter a day [1-29]: ";
    public String dayPromptNonLeap = "Enter day for February\n EX: [1-28]: ";
    public String dayExceptionPrompt = "Invalid Day for February!\nPlease remember to use the correct value for day!\n";
    Scanner KEYBOARD  = new Scanner(System.in);

    public void februaryHandler() throws DayException {
        if (month.leapYearPredicate.test(month.yearSupplier.get())) {
            try {
                System.out.println("Enter day for leap year\n EX: [1-29]: ");
                leapDay = KEYBOARD.nextInt();
                if (leapDay < 1 || leapDay > 29) {
                    throw new DayException(dayExceptionPrompt);
                } else {
                    System.out.printf("%s %d%s\n", month.MONTH_TO_STRING.get(2), leapDay, dateCases(leapDay));
                }
            } catch (DayException e) {
                System.out.println(e.getMessage());
                boolChecker.test(0);
                finalDay();
            }
        } else {
            try {
                System.out.println(dayPromptNonLeap);
                leapDay = KEYBOARD.nextInt();
                if (leapDay < 1 || leapDay > 28) {
                    throw new DayException(dayExceptionPrompt);
                }
            } catch(DayException exception) {
                boolChecker.test(1);
                finalDay();
            }
            System.out.println(dayPromptNonLeap);
            MonthDay notLeapYear = MonthDay.of(2, leapDay);
            System.out.println(notLeapYear);
        }
    }
    Predicate<Integer> boolChecker = i -> i == 0;
    public void finalDay() {
        if (boolChecker.test(0)) {
            do {
                System.out.println(dayPromptLeap);
                leapDay = KEYBOARD.nextInt();
            } while (leapDay < 1 || leapDay > 29);
            System.out.printf("%s %d%s\n", month.MONTH_TO_STRING.get(2), leapDay, dateCases(leapDay));
        } else if (boolChecker.test(1))  {
            do {
                System.out.println(dayPromptNonLeap);
                leapDay = KEYBOARD.nextInt();
            } while(leapDay < 1 || leapDay > 28);
        } else {
            System.out.printf("%s %d%s\n", month.MONTH_TO_STRING.get(2), leapDay, dateCases(leapDay));
        }

    }

//this is a nice use of the switch Expressions
    public String dateCases(int userInput) {
        return switch(userInput) {
            case 1, 21 -> "st";
            case 2, 22 -> "nd";
            case 3, 23 -> "rd";
            case 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 24, 25, 26, 27, 28, 29 -> "th";
            default -> "";
        };
    }

}
