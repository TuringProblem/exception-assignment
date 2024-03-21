package src.months;

public class MonthHandler {
    public void remainingMonths() {
        System.out.println("fuck you");
    }


    public int daysCase(MonthValidator.MyMonths value) {
        return  switch (value) {
            case JAN -> MonthValidator.MyMonths.JAN.getDays();
            case MAR -> MonthValidator.MyMonths.MAR.getDays();
            case APR -> MonthValidator.MyMonths.APR.getDays();
            case MAY -> MonthValidator.MyMonths.MAY.getDays();
            case JUN -> MonthValidator.MyMonths.JUN.getDays();
            case JUL -> MonthValidator.MyMonths.JUL.getDays();
            case AUG -> MonthValidator.MyMonths.AUG.getDays();
            case SEP -> MonthValidator.MyMonths
            default -> 0;

        };
    }
}