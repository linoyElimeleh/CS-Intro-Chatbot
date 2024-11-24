public class Solution {
    public static void main(String[] args) {
        System.out.println(timeCalcSolution("12:14","10")); // 12:24 PM
        System.out.println(timeCalcSolution("10:04","56")); // 11:00 PM
        System.out.println(timeCalcSolution("11:25","35")); // 12:00 PM
        System.out.println(timeCalcSolution("23:25","35")); // 00:00 AM
        System.out.println(timeCalcSolution("01:08","37")); // 1:45 AM
        System.out.println(timeCalcSolution("25:62","10")); // Invalid Input
        System.out.println(timeCalcSolution("23:10","120")); // 1:10 AM
        System.out.println(timeCalcSolution("09:05","2880")); // 9:05 AM 
        System.out.println(timeCalcSolution("ay*4&","10"));// Invalid Input
        System.out.println(timeCalcSolution("02:16","&a2"));// Invalid Input
        System.out.println(timeCalcSolution("04:53","-54")); // 3:59 AM
        System.out.println(timeCalcSolution("00:15","-70")); // 11:05 PM
        System.out.println(timeCalcSolution("15:34","-178")); // 12:36 PM
        System.out.println(timeCalcSolution("13:18","-200")); // 9:58 AM
        System.out.println(timeCalcSolution("19421","40")); // Invalid Input
        System.out.println(timeCalcSolution("123:4","20")); // Invalid Input
        System.out.println(timeCalcSolution("9:821","-178")); // Invalid Input
        System.out.println(timeCalcSolution("393:321","-178")); // Invalid Input
        System.out.println(timeCalcSolution("a","-600")); // Invalid Input        

    }
    public static String timeCalcSolution(String input1, String input2) {
        String time = input1;
        String mins = input2;
        
        if (time.length() != 5 || time.indexOf(':')==-1){
            return "Invalid input";
        }
        String digits = "0123456789";
        if (digits.indexOf(time.charAt(0)) == -1 || digits.indexOf(time.charAt(1)) == -1 || digits.indexOf(time.charAt(3)) == -1 || digits.indexOf(time.charAt(4)) == -1){
            return "Invalid input";
        }
        boolean flag = true;
        int sign = mins.charAt(0) == '-' ? -1 : 1;
        int startIndex = mins.charAt(0) == '-' ? 1 : 0;

        for (int i = startIndex; i < mins.length() && flag; i++) {
            flag = (digits.indexOf(mins.charAt(i)) != -1);
        } 
        if (!flag){
            return "Invalid input";
        }
        int hours = Integer.parseInt("" + time.charAt(0) + time.charAt(1));
		int minutes = Integer.parseInt("" + time.charAt(3) + time.charAt(4));
        if (hours > 23 || hours < 0 || minutes > 59 || minutes < 0){
            return "Invalid input";
        }
        int totalMinutesToCalc = Math.abs(Integer.parseInt(mins));
        int hoursToCalc = totalMinutesToCalc / 60;
        int minsToCalc = totalMinutesToCalc % 60;
        int minsResult = minutes + (sign * minsToCalc);
        int hoursToCarry = 0;
        if (minsResult < 0 || minsResult > 59){
            if (minsResult < 0){
                hoursToCarry--;
                minsResult += 60;
            }else{
                hoursToCarry++;
                minsResult -= 60;
            }
        }
        int hoursResult = hours + hoursToCarry + (sign * hoursToCalc);
        if (hoursResult >= 24 || hoursResult < 0 ){
            if (hoursResult >= 24){
                hoursResult = hoursResult % 24;
            } else {
                hoursResult += 24;
            }
        }
        String minutesFormatted = (minsResult >= 10) ? minsResult+"" : ("0" + minsResult);
        String amPm = (hoursResult >= 12) ? " PM" : " AM";
        int hoursFormatted = (hoursResult > 12) ? hoursResult - 12 : hoursResult;

        return("" + hoursFormatted + ":" + minutesFormatted + amPm);


    }
    
}
