package src.months;
import exception.DayException;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 * @author Override
 * @since 03/18/2024 @14:07
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 */

public class FebruaryHandler {
    MonthValidator month = new MonthValidator();

    /**
     * Leap day, is private value used
     */
    private int myDay;
    public String dayPromptLeap = "Incorrect value\n Please enter a day [1-29]: ";
    public String dayPromptNonLeap = "Enter day for February\n EX: [1-28]: ";
    public String dayExceptionPrompt = "Invalid Day for February!\nPlease remember to use the correct value for day!\n";
    Scanner KEYBOARD  = new Scanner(System.in);

    public boolean isValid(MonthValidator.MyMonths month, int day, int year) {
        int total = switch(month) {
            case FEB -> this.month.leapYearPredicate.test(year) ? 29 : month.getDays();
            default -> month.getDays();
        };
        return day <= total;
    }

    public void expectedOutput() {
        System.out.printf("%s %d%s\n", MonthValidator.MyMonths.FEB.getName(), myDay, dateCases(myDay));
    }

    public Supplier<Integer> yearSupplier = () -> {
        System.out.println("Please enter the year: ");
        return KEYBOARD.nextInt();
    };

    public void februaryHandler()  {
        if (!month.leapYearPredicate.test(yearSupplier.get())) {
            try {
                System.out.println("Enter day for leap year\n EX: [1-29]: ");
                myDay = KEYBOARD.nextInt();
                if (myDay < 1 || myDay > 29) {
                    throw new DayException(dayExceptionPrompt);
                } else {
                    expectedOutput();
                }
            } catch (DayException e) {
                System.out.println(e.getMessage());
                finalDay();
            }
        } else {
            try {
                System.out.println(dayPromptNonLeap);
                myDay = KEYBOARD.nextInt();
                if (myDay < 1 || myDay > 28) {
                 throw new DayException( );
                }
            } catch(DayException exception) {
                finalDay();
            }
            System.out.println(dayPromptNonLeap);
            expectedOutput();
        }
    }

    public void finalDay() {
        System.out.println("I will ask again for the year, make sure you input the correct values that are prompted!\n");
        if (!month.leapYearPredicate.test(yearSupplier.get())) {
            do {
                System.out.println(dayPromptLeap);
                myDay =  KEYBOARD.nextInt();
            } while (myDay < 1 || myDay > 29);
            expectedOutput();
        } else {
            do {
                System.out.println(dayPromptNonLeap);
                 myDay = KEYBOARD.nextInt();
            } while (myDay < 1 || myDay > 28);
            expectedOutput();
        }
    }

    /**
     * @param userInput -> takes the input from the user
     * @return -> The corresponding value for the integer
     */

    public String dateCases(int userInput) {
        return switch(userInput) {
            case 1, 21, 31 -> "st";
            case 2, 22 -> "nd";
            case 3, 23 -> "rd";
            case 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 24, 25, 26, 27, 28, 29, 30 -> "th";
            default -> "";
        };
    }

}
