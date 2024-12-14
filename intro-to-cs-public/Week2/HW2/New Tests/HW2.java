import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        String command = args[0];
        //Show all files needed
        if (command.equals("files")) {
            System.out.println("TimeCalc.java");
            System.out.println("TestRandom.java");
            System.out.println("Cheers.java");
            System.out.println("CalcPi.java");
            System.out.println("Collatz.java");
        } else if (command.equals("tests1")) {
            //The tests for GETFEED:
            System.out.println("java TimeCalc 12:14 10 | java HW2 TimeCalc 12:14 10 1");//1
            System.out.println("java TimeCalc 10:04 56 | java HW2 TimeCalc 10:04 56 1");//2
            System.out.println("java TimeCalc 11:25 35 | java HW2 TimeCalc 11:25 35 1");//3
            System.out.println("java TimeCalc 23:25 35 | java HW2 TimeCalc 23:25 35 1");//4
            System.out.println("java TimeCalc 01:08 37 | java HW2 TimeCalc 01:08 37 1");//5
            System.out.println("java TimeCalc 25:62 10 | java HW2 TimeCalc 25:62 10 1");//6
            System.out.println("java TimeCalc 23:10 120 | java HW2 TimeCalc 23:10 120 1");//7
            System.out.println("java TimeCalc 09:05 2880 | java HW2 TimeCalc 09:05 2880 1");//8
            System.out.println("java TimeCalc ay*4) 10 | java HW2 TimeCalc ay*4) 10 1");//9
            System.out.println("java TimeCalc 02:16 *a2 | java HW2 TimeCalc 02:16 *a2 1");//10
            System.out.println("java TimeCalc 04:53 -54 | java HW2 TimeCalc 04:53 -54 1");//11
            System.out.println("java TimeCalc 00:15 -70 | java HW2 TimeCalc 00:15 -70 1");//12
            System.out.println("java TimeCalc 15:34 -178 | java HW2 TimeCalc 15:34 -178 1");//13
            System.out.println("java TimeCalc 13:18 -200 | java HW2 TimeCalc 13:18 -200 1");//14
            System.out.println("java TimeCalc 09:21 -615 | java HW2 TimeCalc 09:21 -615 1");//15
            System.out.println("java TimeCalc 19421 40 | java HW2 TimeCalc 19421 40 1");//16
            System.out.println("java TimeCalc 123:1 20 | java HW2 TimeCalc 123:1 20 1");//17
            System.out.println("java TimeCalc 9:821 70 | java HW2 TimeCalc 9:821 70 1");//18
            System.out.println("java TimeCalc 393:321 2839 | java HW2 TimeCalc 393:321 2839 1");//19
            System.out.println("java TimeCalc a -600 | java HW2 TimeCalc a -600 1");//20
            
            System.out.println("java TestRandom 5000 | java HW2 TestRandom 5000 5");
            System.out.println("java TestRandom 10000 | java HW2 TestRandom 10000 5");
            System.out.println("java TestRandom 100000 | java HW2 TestRandom 100000 5");

            System.out.println("java Cheers RUNI 5 | java HW2 Cheers RUNI 5 3");
            System.out.println("java Cheers RunI 5 | java HW2 Cheers RunI 5 3");
            System.out.println("java Cheers HellOWorld 10 | java HW2 Cheers HellOWorld 10 3");
            System.out.println("java Cheers psst 2 | java HW2 Cheers psst 2 3");
            System.out.println("java Cheers UEFA 1 | java HW2 Cheers UEFA 1 3");

            System.out.println("java CalcPi 5 | java HW2 CalcPi 5 4");
            System.out.println("java CalcPi 7 | java HW2 CalcPi 7 4");
            System.out.println("java CalcPi 10 | java HW2 CalcPi 10 4");
            System.out.println("java CalcPi 100 1 | java HW2 CalcPi 100 4");
            System.out.println("java CalcPi 1000 1 | java HW2 CalcPi 1000 4");

            System.out.println("java Collatz 1 c | java HW2 Collatz 1 c 1");
            System.out.println("java Collatz 1 v | java HW2 Collatz 1 v 1");
            System.out.println("java Collatz 3 c | java HW2 Collatz 3 c 2");
            System.out.println("java Collatz 3 v | java HW2 Collatz 3 v 2");
            System.out.println("java Collatz 7 c | java HW2 Collatz 7 c 3");
            System.out.println("java Collatz 7 v | java HW2 Collatz 7 v 3");
            System.out.println("java Collatz 10 c | java HW2 Collatz 10 c 4");
            System.out.println("java Collatz 10 v | java HW2 Collatz 10 v 4");
            System.out.println("java Collatz 100 c | java HW2 Collatz 100 c 5");
            System.out.println("java Collatz 1000 c | java HW2 Collatz 1000 c 5");

        
        } else if (command.equals("tests2")) {
            //The tests for MOODLE:
            System.out.println("java TimeCalc 12:14 10 | java HW2 TimeCalc 12:14 10 1");//1
            System.out.println("java TimeCalc 10:04 56 | java HW2 TimeCalc 10:04 56 1");//2
            System.out.println("java TimeCalc 11:25 35 | java HW2 TimeCalc 11:25 35 1");//3
            System.out.println("java TimeCalc 23:25 35 | java HW2 TimeCalc 23:25 35 1");//4
            System.out.println("java TimeCalc 01:08 37 | java HW2 TimeCalc 01:08 37 1");//5
            System.out.println("java TimeCalc 25:62 10 | java HW2 TimeCalc 25:62 10 1");//6
            System.out.println("java TimeCalc 23:10 120 | java HW2 TimeCalc 23:10 120 1");//7
            System.out.println("java TimeCalc 09:05 2880 | java HW2 TimeCalc 09:05 2880 1");//8
            System.out.println("java TimeCalc ay*4) 10 | java HW2 TimeCalc ay*4) 10 1");//9
            System.out.println("java TimeCalc 02:16 *a2 | java HW2 TimeCalc 02:16 *a2 1");//10
            System.out.println("java TimeCalc 04:53 -54 | java HW2 TimeCalc 04:53 -54 1");//11
            System.out.println("java TimeCalc 00:15 -70 | java HW2 TimeCalc 00:15 -70 1");//12
            System.out.println("java TimeCalc 15:34 -178 | java HW2 TimeCalc 15:34 -178 1");//13
            System.out.println("java TimeCalc 13:18 -200 | java HW2 TimeCalc 13:18 -200 1");//14
            System.out.println("java TimeCalc 09:21 -615 | java HW2 TimeCalc 09:21 -615 1");//15
            System.out.println("java TimeCalc 19421 40 | java HW2 TimeCalc 19421 40 1");//16
            System.out.println("java TimeCalc 123:1 20 | java HW2 TimeCalc 123:1 20 1");//17
            System.out.println("java TimeCalc 9:821 70 | java HW2 TimeCalc 9:821 70 1");//18
            System.out.println("java TimeCalc 393:321 2839 | java HW2 TimeCalc 393:321 2839 1");//19
            System.out.println("java TimeCalc a -600 | java HW2 TimeCalc a -600 1");//20

            System.out.println("java TestRandom 5000 | java HW2 TestRandom 5000 5");
            System.out.println("java TestRandom 10000 | java HW2 TestRandom 10000 5");
            System.out.println("java TestRandom 100000 | java HW2 TestRandom 100000 5");

            System.out.println("java Cheers RUNI 5 | java HW2 Cheers RUNI 5 3");
            System.out.println("java Cheers RunI 5 | java HW2 Cheers RunI 5 3");
            System.out.println("java Cheers HellOWorld 10 | java HW2 Cheers HellOWorld 10 3");
            System.out.println("java Cheers psst 2 | java HW2 Cheers psst 2 3");
            System.out.println("java Cheers UEFA 1 | java HW2 Cheers UEFA 1 3");

            System.out.println("java CalcPi 5 | java HW2 CalcPi 5 4");
            System.out.println("java CalcPi 7 | java HW2 CalcPi 7 4");
            System.out.println("java CalcPi 10 | java HW2 CalcPi 10 4");
            System.out.println("java CalcPi 100 1 | java HW2 CalcPi 100 4");
            System.out.println("java CalcPi 1000 1 | java HW2 CalcPi 1000 4");

            System.out.println("java Collatz 1 c | java HW2 Collatz 1 c 1");
            System.out.println("java Collatz 1 v | java HW2 Collatz 1 v 1");
            System.out.println("java Collatz 3 c | java HW2 Collatz 3 c 2");
            System.out.println("java Collatz 3 v | java HW2 Collatz 3 v 2");
            System.out.println("java Collatz 7 c | java HW2 Collatz 7 c 3");
            System.out.println("java Collatz 7 v | java HW2 Collatz 7 v 3");
            System.out.println("java Collatz 10 c | java HW2 Collatz 10 c 4");
            System.out.println("java Collatz 10 v | java HW2 Collatz 10 v 4");
            System.out.println("java Collatz 100 c | java HW2 Collatz 100 c 5");
            System.out.println("java Collatz 1000 c | java HW2 Collatz 1000 c 5");
            /*
             * System.out.println("java Collatz 100 v | java HW2 Collatz 100 v 5");
             * System.out.println("java Collatz 100 c | java HW2 Collatz 100 c 5");
             * 
             * System.out.println("java Collatz 26 v | java HW2 Collatz 26 v 5");
             * System.out.println("java Collatz 100 c | java HW2 Collatz 100 c 5");
             * 
             * System.out.println("java Collatz 100 v | java HW2 Collatz 100 v 4");
             * System.out.println("java Collatz 100 c | java HW2 Collatz 100 c 4");
             * System.out.println("java Collatz 1000 v | java HW2 Collatz 1000 v 5");
             * System.out.println("java Collatz 1000 c | java HW2 Collatz 1000 c 5");
             */

        } else if (command.equals("TimeCalc")) {
            //Test TimeCalc program
            timeCalcTest(args, false);
        } else if (command.equals("TestRandom")) { 
            //Test TestRandom program
            testRandomTest(args, false);
        } else if (command.equals("Cheers")) {
            //Test Cheers program
            cheersTest(args, false);
        } else if (command.equals("CalcPi")) {
            //Test CalcPi program
            calcPiTest(args, false);
        } else if (command.equals("Collatz")) {
            //Test Collatz program
            collatzTest(args, false);
        }
    }

    ////////////////////
    // Q1 - TimeCalc
    // TEST TimeCalc.java TEST
    public static void timeCalcTest(String[] args, boolean failAnyway) {
        String testName = args[0] + ".java test";
        String studentSolution = null;
        try {
            Scanner sc = new Scanner(System.in);
            studentSolution = sc.nextLine();
        }
        catch(Exception e) {
            failAnyway = true;
        }
        String solution = timeCalcSolution(args);
        boolean test = solution.equals(studentSolution);

        if (!test || failAnyway) {
            String msg = testName + " failed with\n time = " + args[1] + ", minutesToCalc = " + args[2] 
            +"\nCorrect solution:\n" + solution + "\nYour solution:\n" + studentSolution;
            printGETFEED(msg);
        }
        
    }

    ////////////////////
    // Q1 - TimeCalc
    // SOLUTION TimeCalc.java SOLUTION
    public static String timeCalcSolution(String [] args) {
        String time = args[1];
        String mins = args[2];
        
        if (time.length() != 5 || time.indexOf(':') == -1){
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
        int hours = Integer.parseInt("" + args[1].charAt(0) + args[1].charAt(1));
		int minutes = Integer.parseInt("" + args[1].charAt(3) + args[1].charAt(4));
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
            } else {
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


    
    ////////////////////
    // Q2 - TestRandom
    // TEST TestRandom.java TEST
    public static void testRandomTest(String[] args, boolean failAnyway) {
        String testName = args[0] + ".java test";
        String [] solution = testRandomSolution(args);
        String [] studentSolution = new String [3];
        try {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < studentSolution.length; i++) {
                studentSolution[i] = sc.nextLine();
            }
        }
        catch(Exception e) {
            failAnyway = true;
        }
        
        boolean test = testRandomSolutionChecker(args,studentSolution);
        
        
        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments: "
            +"\n num = " + args[1]
            +"\nCorrect solution's format:\n" + solution[0] + "\n" + solution[1] + "\n" + solution[2] + "\n" 
            + "Your solution's format: \n" + studentSolution[0] + "\n" + studentSolution[1] + "\n" + studentSolution[2] + "\n"
            + "Check the PDF for better details";
            printGETFEED(msg);
        } 
    }

    ////////////////////
    // Q2 - TestRandom
    // SOLUTION TestRandom.java SOLUTION
    public static String [] testRandomSolution(String[] args) {
        int times = Integer.parseInt(args[1]);
		int count = 0;
		for (int i = 0; i < times; i++) {
			if (Math.random() > 0.01){  // should be 0.5 but for some reason the getfeed is working oddly when randomizing a number
				count++;
			}
			i++;
		}
        String [] strings = new String[3];
        strings[0] = "> 0.5:  " + count + " times.";
		strings[1] = "<= 0.5: " + (times - count) + " times.";
        strings[2] = "Ratio:  " + (count+0.0) / (times - count);
        return strings;		
    }

    public static boolean testRandomSolutionChecker(String [] args,String [] studentsSolution) {
        int times = Integer.parseInt(args[1]);
        int num1 = Integer.parseInt(studentsSolution[0].substring(studentsSolution[0].indexOf(":")+3,studentsSolution[0].indexOf("t")-1));
        int num2 = Integer.parseInt(studentsSolution[1].substring(studentsSolution[1].indexOf(":")+2,studentsSolution[1].indexOf("t")-1));
        double ratio = Double.parseDouble(studentsSolution[2].substring(studentsSolution[2].indexOf('.')-1));
        return(studentsSolution[0].substring(0,studentsSolution[0].indexOf(":")).equals("> 0.5")
            && studentsSolution[1].substring(0,studentsSolution[1].indexOf(":")).equals("<= 0.5")
            && studentsSolution[0].substring(studentsSolution[0].indexOf("t")).equals("times.")
            && studentsSolution[1].substring(studentsSolution[1].indexOf("t")).equals("times.")
            && studentsSolution[2].substring(0,studentsSolution[2].indexOf(":")).equals("Ratio")
            && (num1+num2 == times) && (((num1)+0.0)/ (times-num1) == ratio || ((num2+0.0)/times-num2) == ratio));
    }

    

    ////////////////////
    // Q3 - Cheers
    // TEST Cheer.java TEST
    public static void cheersTest(String[] args, boolean failAnyway) {

        String testName = args[0] + ".java test";
        String text = args[1];
        int times = Integer.parseInt(args[2]);

        int total = text.length() + 1 + times;
        
        String [] solution = cheersSolution(args,total);
        String [] studentSolution = new String[solution.length];
    
        boolean test = true;
        try {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < solution.length; i++) {
                studentSolution[i] = sc.nextLine(); 
                if (!studentSolution[i].equals(solution[i]) && !(i == solution.length - 1 && studentSolution[i] == null)){
                    test = false;
                    break;
                }
                   
            }
        }
        catch(Exception e) {
            
            failAnyway = true;
        }

        if (!test || failAnyway) {
            String msg = testName + " failed with arguments:"
            + "Word: " +args[1] + " Num: " + args[2]
            + "\nCorrect solution:\n"
            + cheersPrint(solution)
            + "\nYour solution:\n"
            + cheersPrint(studentSolution);
            printGETFEED(msg);
        } 

    }

    ////////////////////
    // Q3 - Cheers
    // SOLUTION Cheers.java SOLUTION
    public static String [] cheersSolution(String[] args, int total){
        String [] res = new String [total];
        int len = args[1].length();
        for (int i = 0; i < res.length; i++) {
            if (i < len){
                res[i] = "Give me a";
                res[i] += "aeiouAEIOU".indexOf(args[1].charAt(i)) != -1 ? "n ": " ";
                res[i] += args[1].charAt(i) + ": " + args[1].charAt(i) + "!";
            } else if (i > len){
                res[i] = args[1] + "!!!";
            } else {
                res[i] = "What does that spell?";
            }
        }
	    return res;
	}
    public static String cheersPrint(String[] sol){
        String res = "";
        for (int i = 0; i < sol.length; i++) {
            res += i != sol.length - 1 ? sol[i] + "\n": sol[i] ;  
        }
        return res;
    }



    
    ////////////////////
    // Q4 - CalcPi
    // TEST CalcPi.java TEST
    public static void calcPiTest(String[] args, boolean failAnyway) {
        // CHANGE TO TEST OF Q4 HW2
        String testName = args[0] + ".java test";
        int num = Integer.parseInt(args[1]);
        String solution = calcPiSolution(args);
        String studentSolution = "";
        try {
            Scanner sc = new Scanner(System.in);
            studentSolution = sc.nextLine() + "\n" + sc.nextLine();
        }
        catch(Exception e) {
            failAnyway = true;
        }
        String studentCheck = studentSolution.substring(0,studentSolution.lastIndexOf('.')-1);
        String solutionCheck = studentSolution.substring(0,solution.lastIndexOf('.')-1);
        double epsilon = 0.000000000001;
        double studentDouble = Double.parseDouble(studentSolution.substring(studentSolution.lastIndexOf('.')-1));
        double solutionDouble = calcPiSolutionD(args);
        boolean test = studentCheck.equals(solutionCheck) && (Math.abs(solutionDouble-studentDouble) <= epsilon);

        if (!test || failAnyway) {
            String msg = testName + "failed " + testName + "with argument " + num  
            + "\nExpected output:"
            + "\n" + solution
            + "\nYour output:"
            + "\n" + studentSolution;
            printGETFEED(msg);
        }
        
    }

    ////////////////////
    // Q4 - CalcPi
    // SOLUTION CalcPi.java SOLUTION
    public static String calcPiSolution (String [] args) {
        int num = Integer.parseInt(args[1]);
		double sum = 0;
		double numerator = 1;
		for (int i = 0; i < num; i++) {
    	    sum += numerator / (2 * i + 1);
    	    numerator = - numerator;
	    }
		return("pi according to Java: " + Math.PI +"\n" + "pi, approximated:     " + 4.0 * sum);
    }
    public static double calcPiSolutionD (String [] args) {
        int num = Integer.parseInt(args[1]);
		double sum = 0;
		double numerator = 1;
		for (int i = 0; i < num; i++) {
    	    sum += numerator / (2 * i + 1);
    	    numerator = - numerator;
	    }
		return(4.0 * sum);
    }
    ////////////////////
    // Q5 - Collatz
    // TEST Collatz.java TEST
    public static void collatzTest(String[] args, boolean failAnyway) {

        String testName = args[0] + ".java test";
        int max = Integer.parseInt(args[1]);
        boolean collatzMode = args[2].equals("v");
        String solution = "";
        String studentSolution = "";
        boolean test = true;
        if (collatzMode){
            String [] solutionArray = collatzSolutionV(args);
            solution = collatzPrint(solutionArray);
            String [] studentSolutionV = new String [solutionArray.length]; 
            try {
                Scanner sc = new Scanner(System.in);
                int counter = 0;
                while(sc.hasNextLine() && counter < studentSolutionV.length){
                    studentSolutionV[counter++] = sc.nextLine();
                }
                studentSolution = collatzPrint(studentSolutionV);
                test = studentSolution.equals(solution);
            }
            catch(Exception e) {
                failAnyway = true;
            }   
        }else{
            try {
                Scanner sc = new Scanner(System.in);
                studentSolution = sc.nextLine();
                solution = collatzSolutionC(args);
                test = studentSolution.equals(solution);
            } catch (Exception e) {
                failAnyway = true;
            } 
        }
        if (!test || failAnyway) {
            String msg = "Failed test "+ testName + " with arguments max : " + max + " mode :" + args[2]
            + "\nExpected output:"
            + "\n" + solution + " " 
            + "\nYour output:"
            + "\n" + studentSolution;
            printGETFEED(msg);
        }
    }

    private static String collatzPrint(String[] sol){
        String res = "";
        for (int i = 0; i < sol.length; i++) {
            res += i != sol.length - 1 ? sol[i] + "\n": sol[i] ;  
        }
        return res;
    }

    private static String collatzSolutionC(String[] args){
        int highestSeed = Integer.parseInt(args[1]); 
		// Checks the Collatz conjecture for seeds going from 1 to highestSeeed.
		for (int seed = 1; seed <= highestSeed; seed++) {
			int x = seed;
			boolean flag = false;
			String output = x + " ";
			// Generates a hailstorm sequence, until it reaches 1.
			int count = 1;
			while (x != 1 || !flag){
				if (!flag){
					flag = true;
				}
				if (x % 2 == 0) {
					x = x / 2;
				} else {
					x = 3 * x + 1;
				}
				output = output + x + " ";
				count++;
			}
            
			// If the mode is "verbose", prints the sequence
		}
		return("The first " + highestSeed + " hailstone sequences reached 1.");
    }
    private static String [] collatzSolutionV(String[] args){
        int highestSeed = Integer.parseInt(args[1]); 
        String[] result = new String [highestSeed+1];
		// Checks the Collatz conjecture for seeds going from 1 to highestSeeed.
		for (int seed = 1; seed <= highestSeed; seed++) {
			int x = seed;
			boolean flag = false;
			String output = x + " ";
			// Generates a hailstorm sequence, until it reaches 1.
			int count = 1;
			while(x != 1 || !flag){
				if (!flag){
					flag = true;
				}
				if (x % 2 == 0) {
					x = x / 2;
				} else {
					x = 3 * x + 1;
				}
				output = output + x + " ";
				count++;
			}
			// If the mode is "verbose", prints the sequence
			result[seed-1] = (output + "(" + count + ")");
			
		}
		result[result.length-1] = ("The first " + highestSeed + " hailstone sequences reached 1.");
        return result;
    }

    ///////////////////////////////////
    // Print to GETFEED
    public static void printGETFEED(String msg) {
        System.out.println("GETFEED: " + msg + "\n\n:GETFEED");
    }

}