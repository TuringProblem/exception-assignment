package src;
import exception.DayException;
import exception.MonthException;
import java.time.Month;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.Scanner;
public class MonthValidator {

    private String userInput;
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
    public String caseHandler(int value) {
        return switch (value) {
            case 1 -> MONTH_TO_STRING.get(1);
            case 2 ->MONTH_TO_STRING.get(2);
            case 3 -> MONTH_TO_STRING.get(3);
            case 4 ->  MONTH_TO_STRING.get(4);
            case 5 ->  MONTH_TO_STRING.get(5);
            case 6 -> MONTH_TO_STRING.get(6);
            case 7 -> MONTH_TO_STRING.get(7);
            case 8 -> MONTH_TO_STRING.get(8);
            case 9 -> MONTH_TO_STRING.get(9);
            case 10 -> MONTH_TO_STRING.get(10);
            case 11 -> MONTH_TO_STRING.get(11);
            case 12 -> MONTH_TO_STRING.get(12);
            default -> "";
        };
    }
    public Supplier<String> monthSupplier = () -> {
        System.out.println("MONTHS [1 = January] [2 = February] , etc... \nEnter a month [1-12]: ");
        int value = KEYBOARD.nextInt();
        return caseHandler(value); };

    public static FebruaryHandler feb = new FebruaryHandler();
    public final Predicate<Integer> leapYearPredicate = i -> i % 4 == 0 && i % 400 == 0;

    /**
     * Method {@link #checkMonth()} -> Validates that the user has input the correct month:
     * @throws MonthException -> if the user's input is invalid.
     */



    public void checkMonth() throws MonthException, DayException {
        userInput = monthSupplier.get();
        try {
            if(userInput.isEmpty()) {
                throw new MonthException("You cannot use that value!\n");
            }
            if (userInput.equals("February")) {
                feb.februaryHandler();
            }
        } catch (MonthException e) {
            System.out.println(e.getMessage());
            System.out.println("This is your last chance!\n");
            lastMonthChance();
        }
    }


    /**
     * {@link #lastMonthChance()} -> gives the user one last chance:
     * Verifies that the user has input the correct information
     */

    public void lastMonthChance() throws DayException {
        userInput = monthSupplier.get();
        if (userInput.equals("February")) {
                feb.februaryHandler();
        } else {
            System.out.println("you have still been unable to give a valid month\n Good bye! :)");
            System.exit(0);
        }
    }

}
