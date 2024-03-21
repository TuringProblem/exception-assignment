package src.months;
import exception.DayException;
import exception.MonthException;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.Scanner;
/**
 * @author Override
 * @since 3/20/2024 @19:32
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 */
public class MonthValidator {

    private String userInput;


    /**
     * @see Map -> using Map to associate months key value's with its corresponding String
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

    public String caseHandler(int value) {
        return switch (value) {
            case 1 -> MONTH_TO_STRING.get(1);
            case 2 -> MONTH_TO_STRING.get(2);
            case 3 -> MONTH_TO_STRING.get(3);
            case 4 -> MONTH_TO_STRING.get(4);
            case 5 -> MONTH_TO_STRING.get(5);
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
        Scanner KEYBOARD = new Scanner(System.in);
        System.out.println("MONTHS [1 = January] [2 = February] , etc... \nEnter a month [1-12]: ");
        int value = KEYBOARD.nextInt();
        return caseHandler(value);
    };

    /**
     * @see FebruaryHandler -> Handles the month of February
     */

    public static FebruaryHandler FEB = new FebruaryHandler();
    public static MonthHandler MONTH = new MonthHandler();


    /**
     * @see Predicate -> Checks if the year passed by the user is a Leap year
     */

    public final Predicate<Integer> leapYearPredicate = i -> i % 4 == 0 && i % 400 == 0;


    public void checkMonth() throws  DayException {
        userInput = monthSupplier.get();
        try {
            if (userInput.isEmpty()) {
                throw new MonthException("You cannot use that value!\n");
            }
            if (userInput.equals("February")) {
                FEB.februaryHandler();
            } else {

            }
        } catch (MonthException e) {
            System.out.println(e.getMessage());
            System.out.println("This is your last chance!\n");
            lastMonthChance();
        }
    }


    public void lastMonthChance() throws DayException {
        userInput = monthSupplier.get();
        if (userInput.equals("February")) {
            FEB.februaryHandler();
        } else {
            System.out.println("you have still been unable to give a valid month\n Good bye! :)");
            System.exit(0);
        }
    }
}
