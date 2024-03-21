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
     * @see Map -> Using enum to set day values, and Name values of the month, and days
     */

    public enum MyMonths {
        JAN("January", 31),
        FEB("February", 28),
        MAR("March", 31),
        APR("April", 30),
        MAY("May", 31),
        JUN("June", 30),
        JUL("July", 31),
        AUG("August", 31),
        SEP("September", 30),
        OCT("October", 31),
        NOV("November", 30),
        DEC("December", 31);

        private final String name;
        private final int days;
        MyMonths(String name, int days) {
            this.name = name;
            this.days = days;
        }
        public String getName() { return name; }
        public int getDays() { return days; }
    }

    public String caseHandler(int value) {
        return switch (value) {
            case 1 -> MyMonths.JAN.getName();
            case 2 -> MyMonths.FEB.getName();
            case 3 -> MyMonths.MAR.getName();
            case 4 -> MyMonths.APR.getName();
            case 5 -> MyMonths.MAY.getName();
            case 6 -> MyMonths.JUN.getName();
            case 7 -> MyMonths.JUL.getName();
            case 8 -> MyMonths.AUG.getName();
            case 9 -> MyMonths.SEP.getName();
            case 10 -> MyMonths.OCT.getName();
            case 11 -> MyMonths.NOV.getName();
            case 12 -> MyMonths.DEC.getName();
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

    public final Predicate<Integer> leapYearPredicate = i -> i % 4 == 0 && (i % 100 != 0 || i % 400 == 0);

    public void checkMonth() throws MonthException,  DayException {
        userInput = monthSupplier.get();
        try {
            if (userInput.isEmpty()) {
                throw new MonthException("You cannot use that value!\n");
            }
            if (userInput.equals("February")) {
                FEB.februaryHandler();
            } else {
                remainingMonths();
            }

        } catch (MonthException e) {
            System.out.println(e.getMessage());
            System.out.println("This is your last chance!\n");
            lastMonthChance();
        }
    }

    public void lastMonthChance() throws MonthException, DayException {
        userInput = monthSupplier.get();
        if (userInput.isEmpty()) {
            System.out.println("you have still been unable to give a valid month\n Good bye! :)");
            System.exit(0);
        }
        if (userInput.equals("February")) {
            FEB.februaryHandler();

        } else if (userInput.equals("January")){
            System.out.println("yo");
        }
    }
    public void remainingMonths()throws DayException {
        if (userInput.equals("January")) {
            MONTH.sendJanuary();
        }
    }
}