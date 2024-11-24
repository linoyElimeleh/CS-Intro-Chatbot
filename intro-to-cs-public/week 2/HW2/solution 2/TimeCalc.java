public class TimeCalc {
    public static void main(String[] args) {
        int hours = Integer.parseInt(args[0].substring(0, 2));
        int minutes = Integer.parseInt(args[0].substring(3, 5));
        int minutesToAdd = Integer.parseInt(args[1]);

        /*
        int totalMinutes = hours * 60 + minutes + minutesToAdd;
        int newHours = ((totalMinutes / 60) % 24 + 24) % 24;
        int newMinutes = (totalMinutes % 60 + 60) % 60;
        */

        int totalMinutes = hours * 60 + minutes + minutesToAdd;
        int totalHours = (totalMinutes / 60);
        int newHours = totalHours % 24;
        int newMinutes = totalMinutes - totalHours * 60;

        /*
        System.out.println("Hours: " + hours);
        System.out.println("Minutes: " + minutes);
        System.out.println("Minutes to add: " + minutesToAdd);
        System.out.println("New hours: " + newHours);
        System.out.println("New minutes: " + newMinutes);
        */

        String newHoursStr = "" + newHours;
        if (newHours < 10) {
            newHoursStr = "0" + newHoursStr;
        }
        
        String newMinutesStr = "" + newMinutes;
        if (newMinutes < 10) {
            newMinutesStr = "0" + newMinutesStr;
        }

        System.out.println(newHoursStr + ":" + newMinutesStr);
    }
}
