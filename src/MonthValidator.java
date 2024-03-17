package src;
import exception.MonthException;
import java.util.function.Supplier;
import java.util.Scanner;
public class MonthValidator {
    Scanner KEYBOARD = new Scanner(System.in);
    public Supplier<Integer> monthSupplier = () -> {
        System.out.println("MONTHS [1 = January] [2 = February] , etc... \nEnter a month [1-12]: ");
        return KEYBOARD.nextInt();
    };
    public Supplier<Integer> yearSupplier = () -> {
        System.out.println("Please enter the year: ");
        return KEYBOARD.nextInt();
    };

    public void checkMonth() throws MonthException {
        int month = monthSupplier.get();
        if (month > 12 || month < 1) {
            throw new MonthException();
        } else {
            System.out.println(monthToStringConverter(month));
            if (monthToStringConverter(month).equalsIgnoreCase("february")) {
                if (isLeapYear(yearSupplier.get())) {

                }
            }
        }
    }

    public boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param month -> int value that gets turned into a String value
     * @return -> {@link #monthToStringConverter(int month)} -> {@link #checkMonth()}
     */

    public String monthToStringConverter(int month) {
        return switch (month){
          case 1 -> "January";
          case 2 -> "February";
          case 3 -> "March";
          case 4 -> "April";
          case 5 -> "May";
          case 6 -> "June";
          case 7 -> "July";
          case 8 -> "August";
          case 9 -> "September";
          case 10 -> "October";
          case 11 -> "November";
          case 12 -> "December";
            default ->  " ";
        };
    }
}
