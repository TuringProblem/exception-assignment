package src;
import java.util.Scanner;
import java.util.function.Supplier;
import java.time.Month;

public class DayValidator extends MonthValidator {
    Scanner KEYBOARD = new Scanner(System.in);
    Supplier<Integer> daySupplier = () -> {
        System.out.printf("Please enter the day that you would like for the month of %d\n Please enter a day: ", Month.FEBRUARY);
        return KEYBOARD.nextInt();
    };
    public void checkMonth(Month monthpassed) {
        if (monthpassed == Month.FEBRUARY) {

        }
    }
}
