package src;
import exception.MonthException;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.Scanner;
public class MonthValidator {
    Scanner KEYBOARD = new Scanner(System.in);

    public enum Month {
        JANUARY("January"),
        FEBRUARY("February"),
        MARCH("March"),
        APRIL("April"),
        MAY("May"),
        JUNE("June"),
        JULY("July"),
        AUGUST("August"),
        SEPTEMBER("September"),
        OCTOBER("October"),
        NOVEMBER("November"),
        DECEMBER("December");

        final String month;
        Month(String month) {this.month = month;}
    }

    public Supplier<Integer> monthSupplier = () -> {
        System.out.println("MONTHS [1 = January] [2 = February] , etc... \nEnter a month [1-12]: ");
        return KEYBOARD.nextInt();
    };
    public Predicate<Integer> leapYearPredicate = i -> i % 4 == 0;
    public Predicate<Integer> isValidMonth = i -> i > 12 || i < 1;

    public void checkMonth() throws MonthException {
        int month = monthSupplier.get();
        try {
            if (isValidMonth.test(month)) {
                throw new MonthException("You cannot use that value!\n");

            } else {
                System.out.println(monthToStringConverter(month));
                if (monthToStringConverter(month) == Month.FEBRUARY) {
                    if (leapYearPredicate.test(yearSupplier.get())) {
                        //add logic for if it is a leap year
                    }
                }
            }
        } catch (MonthException e) {
            System.out.println(e.getMessage());
            System.out.println("This is your last chance!\n");
            lastMonthChance();
        }

    }

    public void lastMonthChance() {
        int month = monthSupplier.get();
        if (isValidMonth.test(month)){

        } else if (!isValidMonth.test(month)) {
            System.out.println("you have still been unable to give a valid month\n Good bye! :)");
            System.exit(0);
        }
    }

    /**
     * @param month -> int value that gets turned into a String value
     * @return -> {@link #monthToStringConverter(int month)} -> {@link #checkMonth()}
     */

    public Month monthToStringConverter(int month) {
        return switch (month){
          case 1 -> Month.JANUARY;
          case 2 -> Month.FEBRUARY;
          case 3 -> Month.MARCH;
          case 4 -> Month.APRIL;
          case 5 -> Month.MAY;
          case 6 -> Month.JUNE;
          case 7 -> Month.JULY;
          case 8 -> Month.AUGUST;
          case 9 -> Month.SEPTEMBER;
          case 10 -> Month.OCTOBER;
          case 11 -> Month.NOVEMBER;
          case 12 -> Month.DECEMBER;
            default ->  null;
        };
    }

    public Supplier<Integer> yearSupplier = () -> {
        System.out.println("Please enter the year: ");
        return KEYBOARD.nextInt();
    };
}
