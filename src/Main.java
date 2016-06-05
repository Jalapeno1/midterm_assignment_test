import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<Integer, Integer> months_days = new HashMap<>();

    static
    {
        months_days.put(1, 31);
        months_days.put(2, 28);
        months_days.put(3, 31);
        months_days.put(4, 30);
        months_days.put(5, 31);
        months_days.put(6, 30);
        months_days.put(7, 31);
        months_days.put(8, 31);
        months_days.put(9, 30);
        months_days.put(10, 31);
        months_days.put(11, 30);
        months_days.put(12, 31);
    }

    public static String getNextDay(int day, int month, int year) throws Exception {

        if(!checkValidInput(day, month, year))
            return "Bad input!";

        if(day < months_days.get(month))
            day++;
        else if(month == 2 && isLeapYear(year) && day != 29)
            day++;
        else
        {
            day = 1;
            if (month < 12)
                month++;
            else
            {
                month = 1;
                year++;
            }
        }
        return day + "/" + month + "/" + year;
    }

    private static boolean checkValidInput(int day, int month, int year){
        if(month == 2 && isLeapYear(year) && day == 29) //special check for leap year and day (29)
            return true;
        else if(month < 1 || month > 12 )
            return false;
        else if((year < 1812 || year > 2014))
            return false;
        return !(day < 1 || day > 31 || day > months_days.get(month) );
    }

    public static boolean isLeapYear(int year)
    {
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0);
    }
}
