package src;
import exception.DayException;
import exception.MonthException;
import java.time.Month;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.Scanner;
public class MonthValidator {

    /**
     * @see Map -> using map to collection
     */
    Map<Integer, String> MONTH_TO_STRING = Map.ofEntries(
            Map.entry(1, "January"),
            Map.entry(2, "February"),
            Map.entry(3, "March"),
            Map.entry(4, "April"),
            Map.entry(5, "May"),
            Map.entry(6, "June"),
            Map.entry(7, "July"),
            Map.entry(8, "August"),
            Map.entry(9, "September"),
            Map.entry(10, "October"),
            Map.entry(11, "November"),
            Map.entry(12, "December"));
    Scanner KEYBOARD = new Scanner(System.in);

    /**
     * {@link #monthSupplier} -> .get() the input from the user: Stores value in month
     * @see Month -> <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html">Java Month API</a>
     */

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
     * Method {@link #checkMonth()} -> Validates that the user has input the correct month:
     * @throws MonthException -> if the user's input is invalid.
     */

    public static FebruaryHandler feb = new FebruaryHandler();
    public void checkMonth() throws MonthException, DayException {
        try {
            if (isValidMonth.equals(monthValidation())) {
                throw new MonthException("You cannot use that value!\n");
            }
            if (monthValidation().equals("February")) {
                feb.februaryHandler();
            }
        } catch (MonthException e) {
            System.out.println(e.getMessage());
            System.out.println("This is your last chance!\n");
            lastMonthChance();
        }
    }

    public String monthValidation() {
        int month = monthSupplier.get();
        return MONTH_TO_STRING.get(month);
    }

    /**
     * {@link #lastMonthChance()} -> gives the user one last chance:
     * Verifies that the user has input the correct information
     */

    public void lastMonthChance() throws DayException {

        if (!isValidMonth.equals(monthValidation())) {
            if (monthValidation().equals("February")) {
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
