package src.months;
import exception.DayException;
import exception.MonthException;
import java.util.Map;
import java.util.function.Supplier;
import java.util.Scanner;

/**
 * @author Override
 * @since 3/20/2024 @19:32
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 */

public class MonthValidator {

    /**
     * @see Map -> Using enum to set day values, and Name values of the month, and days due to them being constant values
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
        private final Integer day;
        MyMonths(String name, Integer day) {
            this.name = name;
            this.day = day;
        }
        public String getName() { return name; }//gets the enum name
        public int getDay() { return day; }//gets the enum day
    }

    /**
     * @param value -> The int value passed from the user
     * @return -> return the corresponding enum for the int value
     */
    public MyMonths caseHandler(int value) {
        return switch (value) {
            case 1 -> MyMonths.JAN;
            case 2 -> MyMonths.FEB;
            case 3 -> MyMonths.MAR;
            case 4 -> MyMonths.APR;
            case 5 -> MyMonths.MAY;
            case 6 -> MyMonths.JUN;
            case 7 -> MyMonths.JUL;
            case 8 -> MyMonths.AUG;
            case 9 -> MyMonths.SEP;
            case 10 -> MyMonths.OCT;
            case 11 -> MyMonths.NOV;
            case 12 -> MyMonths.DEC;
            default -> null;
        };
    }

    /**
     * MonthSupplier deals with the value being passed and converts the int to the corresponding value
     */

    public Supplier<MyMonths> monthSupplier = () -> {
        Scanner KEYBOARD = new Scanner(System.in);
        System.out.println("MONTHS [1 = January] [2 = February] , etc... \nEnter a month [1-12]: ");
        int value = KEYBOARD.nextInt();
        return caseHandler(value);
    };

    /**
     * @see FebruaryHandler -> Handles the month of February
     * @see MonthHandler -> Handles the remaining months
     * */

    public static FebruaryHandler FEB = new FebruaryHandler();
    public static MonthHandler MONTH = new MonthHandler();

    /**
     * checkMonth() -> Makes sure that the month being passed is valid
     * @exception MonthException -> If the month passed is invalid, then the users gets one more chance
     * @exception DayException -> If the day passed is invalid, then the user gets one more chance
     */

    public void checkMonth() throws MonthException,  DayException {
       MyMonths userInput = monthSupplier.get();
        try {
            if (userInput == null) {
                throw new MonthException("You cannot use that value!\n");
            } else  if (userInput == MyMonths.FEB) {
                FEB.februaryHandler(userInput);
            } else {
                MONTH.sendResult(userInput);
            }

        } catch (MonthException e) {
            System.out.println(e.getMessage());
            System.out.println("This is your last chance!\n");
            lastMonthChance();
        }
    }

    /**
     *
     * @throws MonthException -> If the user does not input the right value, then the program will end
     * @throws DayException -> If the user does not input the right value, then the program will end
     * lastMonthChance() -> Gives the user one last chance to add the correct value
     */

    public void lastMonthChance() throws MonthException, DayException {
        MyMonths userInput = monthSupplier.get();
        if (userInput == null) {
            System.out.println("you have still been unable to give a valid month\n Good bye! :)");
            System.exit(0);
        } else if (userInput == MyMonths.FEB) {
            FEB.februaryHandler(userInput);
        } else {
            MONTH.sendResult(userInput);
        }
    }

    /**
     * @param userInput -> takes the input from the user
     * @return -> The corresponding value for the users input
     */
    public String dateCases(int userInput) {
        if(userInput > 31 || userInput < 1) return "";
        return switch (userInput) {
            case 1, 21, 31 -> "st";
            case 2, 22 -> "nd";
            case 3, 23 -> "rd";
            default -> "th";
        };
    }
}