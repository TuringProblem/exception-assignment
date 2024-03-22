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
    public  final String dayPromptNonLeap = "Enter day for February\n EX: [1-28]: ";
    public final String dayPromptLeapYear = "Enter day for leap year\n EX: [1-29]: ";
    public String dayExceptionPrompt = "Invalid Day for February!\n";
    public Scanner KEYBOARD  = new Scanner(System.in);

    public void expectedOutput(int valuePassed) {
        System.out.printf("%s %d%s\n", month.caseHandler(valuePassed), myDay, dateCases(myDay));
    }

    public Supplier<Integer> yearSupplier = () -> {
        try {
            System.out.println("Please enter the year: ");
            myDay = KEYBOARD.nextInt();
            if (myDay < 0) {
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

    public void februaryHandler(int monthValue)  {
        if (month.leapYearPredicate.test(yearSupplier.get())) {
            try {
                System.out.println(dayPromptLeapYear);
                myDay = KEYBOARD.nextInt();
                if (myDay < 1 || myDay > 29) {
                    throw new DayException(dayExceptionPrompt);
                } else {
                    expectedOutput(2);
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
                 throw new DayException(dayExceptionPrompt);
                }
            } catch(DayException exception) {
                System.out.println(exception.getMessage());
                finalDay();
            }
            System.out.println(dayPromptNonLeap);
            expectedOutput(2);
        }
    }

    public void finalDay() {
        try {
            System.out.println("Enter the correct value!\nLast chance: ");
            myDay = yearSupplier.get();
            if (month.leapYearPredicate.test(myDay)) {
                System.out.println(dayPromptLeapYear);
                myDay = KEYBOARD.nextInt();
                if (myDay < 1 || myDay > 29) {
                    throw new DayException(dayExceptionPrompt);
                } else {
                    expectedOutput(2);
                }
            }  else {
                System.out.println(dayPromptNonLeap);
                myDay = KEYBOARD.nextInt();
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

    /**
     * @param userInput -> takes the input from the user
     * @return -> The corresponding value for the integerakajsdlkfj
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
