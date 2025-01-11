public class DailyCalendar {
    static private int dailyCalendarsCount = 0;
    private static final int[] numberOfDaysEachMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int day;
    private int month;
    private int year;
    private int hourSplits;
    private String[] plans;

    private DailyCalendar nextDay;

    public DailyCalendar(int day, int month, int year, int hourSplits) {
        initialize(day, month, year, hourSplits);
    }

    public DailyCalendar(String date, int hourSplits) {
        int day = Integer.parseInt(date.substring(0,date.indexOf('/')));
        String rest = date.substring(date.indexOf('/')+1);
        int month = Integer.parseInt(rest.substring(0, rest.indexOf('/')));
        rest =rest.substring(rest.indexOf('/')+1);
        int year = Integer.parseInt(rest);
        initialize(day,month,year,hourSplits);
    }

    private void initialize(int day, int month, int year, int hourSplits){
        this.year = year;
        this.month = getAlignedMonth(month);
        this.day = getAlignedDay(day, this.month, year);
        this.hourSplits = Math.max(1,hourSplits);
        this.plans = new String[24*this.hourSplits];
        dailyCalendarsCount++;
    }

    public void setPlanAt(String plan, int hour) {
        for(int p = 0; p < this.hourSplits; p++) {
            int planIndex = getPlanIndex(hour,p);
            if (this.plans[planIndex] == null) {
                this.plans[planIndex] = plan;
                return;
            }
        }
    }

    public DailyCalendar getNextDayCalendar() {
        if (this.nextDay == null){
            int nextDayInt = getAlignedDay(this.day+1, this.month, this.year);
            if (nextDayInt != this.day) {
                this.nextDay = new DailyCalendar(nextDayInt, this.month,this.year,this.hourSplits);
            } else {
                int nextMonth = getAlignedMonth(this.month+1);
                if (nextMonth != this.month) {
                    this.nextDay = new DailyCalendar(1, nextMonth ,this.year,this.hourSplits);
                } else {
                    this.nextDay = new DailyCalendar(1, 1 ,this.year + 1,this.hourSplits);
                }
            }
        }
        return this.nextDay;
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
        String summary = String.format("%d\\%d\\%d%n", this.day, this.month, this.year);
        for (int h = 0; h < 24; h++) {
            String hourPlans = "";
            for (int p = 0; p < this.hourSplits; p++) {
                int planIndex = getPlanIndex(h,p);
                if (this.plans[planIndex] != null) {
                    hourPlans += " - " + this.plans[planIndex] + "\n";
                }
            }
            if (hourPlans != "") {
                summary += "[" + h + ":00]\n" + hourPlans;
            }
        }
        return summary;
    }

    public int getFollowingDaysCount() {
        if (this.nextDay == null) {
            return 0;
        }

        return this.nextDay.getFollowingDaysCount()+1;
    }

    public String getNextNDaysString(int nDays) {
        String output = this.toString();
        DailyCalendar day = this;
        for(int n = 1; n < nDays; n++) {
            day = day.nextDay;
            if (day == null) {
                break;
            }
            output += "\n\n" + day.toString();
        }

        return output;
    }

    public static int getTotalDailyCalendarsCreated() {
        return dailyCalendarsCount;
    }
}
