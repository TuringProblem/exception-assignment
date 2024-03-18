package src;
import exception.DayException;
import exception.MonthException;
import java.time.Month;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.Scanner;
public class MonthValidator {
    Scanner KEYBOARD = new Scanner(System.in);
    /** * @see Month -> using enum for month validation, due to the months being Constant values. * Using {@link #monthSupplier} -> to get the return value from the user */
    public Supplier<Integer> monthSupplier = () -> {
        System.out.println("MONTHS [1 = January] [2 = February] , etc... \nEnter a month [1-12]: ");
        return KEYBOARD.nextInt(); };

    /**
     * Using Predicate<t> {@link #leapYearPredicate} && {@link #isValidMonth} -> to validate if the months are within the expected range:
     * && if the user picks "February" they will be prompted ot input the year.
     */
    public final Predicate<Integer> leapYearPredicate = i -> i % 4 == 0 && i % 400 == 0;
    public final Predicate<Integer> isValidMonth = i -> i > 12 || i < 1;

    /**
     * {@link #monthSupplier} -> .get() the input from the user: Stores value in month
     * @see Month -> <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html">Java Month API</a>
     */

    /**
     * Method {@link #checkMonth()} -> Validates that the user has input the correct month:
     * @throws MonthException -> if the user's input is invalid.
     */
    public static FebruaryHandler feb = new FebruaryHandler();
    public void checkMonth() throws MonthException, DayException {
        try {
            if (isValidMonth.equals(monthValidation())) {
                throw new MonthException("You cannot use that value!\n");
            }
            if (monthValidation() == Month.FEBRUARY) {
                feb.februaryHandler();
            }
        } catch (MonthException e) {
            System.out.println(e.getMessage());
            System.out.println("This is your last chance!\n");
            lastMonthChance();
        }
    }

    public Month monthValidation() {
        int month = monthSupplier.get();
        Month myMonth = Month.of(month);
        return myMonth;
    }



    /**
     * {@link #lastMonthChance()} -> gives the user one last chance:
     * Verifies that the user has input the correct information
     */

    public void lastMonthChance() throws DayException {

        if (!isValidMonth.equals(monthValidation())) {
            if (monthValidation() == Month.FEBRUARY) {
                feb.februaryHandler();
            }
        } else {
            System.out.println("you have still been unable to give a valid month\n Good bye! :)");
            System.exit(0);
        }
    }

    public Supplier<Integer> yearSupplier = () -> {
        System.out.println("Please enter the year: ");
        return KEYBOARD.nextInt();
    };
}
