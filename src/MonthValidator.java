package src;

import exception.DayException;
import exception.MonthException;

import java.util.function.Supplier;
import java.util.Scanner;
public class MonthValidator {
    Scanner KEYBOARD = new Scanner(System.in);
    public Supplier<Integer> monthSupplier = () -> {
        System.out.println("MONTHS [1 = January] [2 = February] , etc... \nEnter a month [1-12]: ");
        return KEYBOARD.nextInt();
    };
    public void checkMonth() throws MonthException {
        int month = monthSupplier.get();
        if (month > 12 || month < 1) {
            throw new MonthException("", 0);
        }
    }
}
