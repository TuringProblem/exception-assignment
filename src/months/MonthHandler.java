package src.months;
import exception.DayException;
import exception.MonthException;
import java.util.Scanner;
import java.util.function.Function;

/**
 * @author Override
 * @since 03/23/24 @17:56
 * @see <a href="https://Github.com/TuringProblem">GitHub Profile</a>
 */
public class MonthHandler {
    MonthValidator MONTH = new MonthValidator();
    Scanner KEYBOARD = new Scanner(System.in);
    public void printOutput(MonthValidator.MyMonths monthPassed, int days) { System.out.printf("%s %d%s\n", monthPassed.getName(), days, MONTH.dateCases(days)); }

    /**
     * Java Function -> Takes in a parameter and returns a value back.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html">java.util.function</a> for Java documentation
     */
    Function<Integer, Integer> getUserInput = (output) -> {
        System.out.printf("Input a number between [1-%d]: ", output);
        return KEYBOARD.nextInt();
    };

    /**
     * @param months -> Grabs the enum month type:
     * @see MonthValidator -> for enum
     * @throws DayException -> Checks to make sure the users inputs for the day is correct:
     * if not the exception is thrown and the user is prompted one last chance.
     * @throws MonthException -> Checks to make sure the user inputs the correct Month value:
     *  if not the exception is thrown and the user is prompted one last chance.
     */

    public void sendResult(MonthValidator.MyMonths months) throws DayException, MonthException {
        int userInput = getUserInput.apply(months.getDay());
        try {
            if (userInput < 1 || userInput > months.getDay()) {
                throw new DayException("Invalid output:\nThe month of " + months + " has 1-" + months.getDay() + " days\n");
            } else {
                printOutput(months, userInput);
            }
        } catch(DayException e) {
            System.out.println(e.getMessage());
           secondChanceDay(months);
        }
    }

    /**
     * secondChanceDay() -> Last chance for the user to input the correct day for the month passed
     * @param months -> Month passed by the user
     * @throws DayException -> Exception is thrown when the user does not input the correct value
     */

    public void secondChanceDay(MonthValidator.MyMonths months) throws DayException {
        int userInput = getUserInput.apply(months.getDay());
        try {
            if (userInput < 1 || userInput > months.getDay()) {
                throw  new DayException("Invalid output:\nThe program will now close");
            } else {
                printOutput(months, userInput);
            }
        } catch (DayException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}