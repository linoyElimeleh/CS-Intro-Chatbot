public class Main {
    public static void main(String[] args) {
        // #TODO: Step 1, Implement first constructor of DailyCalendar
        DailyCalendar day1 = new DailyCalendar(37,2,2000,2);

        // #TODO: Step 2, Implement second constructor of DailyCalendar
        DailyCalendar day2 = new DailyCalendar("31/13/2003",2);

        // #TODO: Step 3, Implement setPlanAt
        day2.setPlanAt("Do homework", 17);
        day2.setPlanAt("Regret for not get homework done", 17);

        // TODO: Step 4, Implement toString
        System.out.println(day1.toString());
        System.out.println(day2.toString());

        day2.setPlanAt("Clean the house", 11);
        day2.setPlanAt("Clean the house", 13);
        day2.setPlanAt("Clean the house", 12);
        System.out.println(day2.toString());

        // #TODO: Step 5, Implement
        System.out.println(DailyCalendar.getTotalDailyCalendarsCreated());

        // TODO: Step 6, Implement getNextDayCalendar
        DailyCalendar nextDay = day2.getNextDayCalendar();
        nextDay.setPlanAt("Visit family", 15);
        System.out.println(nextDay.toString());

        // TODO: Step 7, implement recursively getFollowingDaysCount
        nextDay.getNextDayCalendar().setPlanAt("WORK WORK WORK WORK WORK",9);
        System.out.println(day2.getFollowingDaysCount());

        // TODO: Step 8, Implement getNextDayCalendar
        System.out.println(day2.getNextNDaysString(3));
    }
}