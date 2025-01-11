public class DailyCalendars {
    private static final int[] numberOfDaysEachMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public DailyCalendars(int day, int month, int year, int hourSplits) {
        // #TODO: Initialize the object and set the proper properties.
        // #TODO: Use getAlignedMonth & getAlignedDay to define a valid date.
        // #TODO: Initialize the array of plans size to be (24 * hourSplits).
    }

    public DailyCalendars(String date, int hourSplits) {
        // #TODO: Extract the logic of the previous constructor out to initialization method.
        // #TODO: Parse the date string and call the initialization method properly to construct the object.
        // Assume string date form is "14/3/2002"
    }

    public void setPlanAt(String plan, int hour) {
        // #TODO: Use getPlanIndex to iterate each hour slot can be used.
        // #TODO: Set the plan at the first slot of hour that found (or dont if not found).
    }

    private static int getAlignedMonth(int month) {
        return Math.max(1, Math.min(month, 12));
    }

    private static int getAlignedDay(int day, int month, int year) {
        if (month == 2 && isLeapYear(year)){
            return Math.max(0, Math.min(day, 29));
        }

        return Math.max(0, Math.min(day, numberOfDaysEachMonth[month-1]));
    }

    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }

    private int getPlanIndex(int hour, int part) {
        return hour * this.hourSplits + part;
    }

    public String toString() {
        // #TODO: Return string that start with the format of the day this object represent.
        // #TODO: Each hour with plans should be presented with the list of it plans.
        // Example of result:
        // 13/7/2023
        // [3:00]
        // - Some plan
        // [17:00]
        // - Some other plan
        // - And another plan at the same hour
    }

    public DailyCalendars getNextDayCalendar(int hourSplits) {
        // #TODO: Check if already defined next day and return it.
        // #TODO: If not, use getAlignedMonth & getAlignedDay to define a valid next day date and set this property than return it.
    }

    public String getNextNDaysString(int nDays) {
        // #TODO: Return string that contained all n' next days toString()
        // #TODO: Stop build the string if arrived nextDay that isn't defined.
    }
}
