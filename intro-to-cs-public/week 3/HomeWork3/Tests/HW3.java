public class HW3 {
    public static void main(String[] args) {
        String command = args[0];


        //Show all files needed
        if (command.equals("files")) {
            System.out.println("Algebra.java");
            System.out.println("StringOps.java");
            System.out.println("Anagram.java");

        } else if (command.equals("tests1")) {
            //The tests for GETFEED:
            System.out.println("java HW3 Algebra plus 1 0 1");
            System.out.println("java HW3 Algebra plus 124271 247811 1");

            System.out.println("java HW3 Algebra minus 1 0 1");
            System.out.println("java HW3 Algebra minus 12 131 1");

            System.out.println("java HW3 Algebra times 11 0 1");
            System.out.println("java HW3 Algebra times 11 1 1");
            System.out.println("java HW3 Algebra times 1278 12 1");

            System.out.println("java HW3 Algebra pow 13 0 1");
            System.out.println("java HW3 Algebra pow 13 1 1");
            System.out.println("java HW3 Algebra pow 1 183 1");
            System.out.println("java HW3 Algebra pow 12 2 1");
            System.out.println("java HW3 Algebra pow 2 10 1");

            System.out.println("java HW3 Algebra div 27 1 1");
            System.out.println("java HW3 Algebra div 26 3 1");
            System.out.println("java HW3 Algebra div 27 3 1");
            System.out.println("java HW3 Algebra div 28 3 1");

            System.out.println("java HW3 Algebra mod 25 3 1");
            System.out.println("java HW3 Algebra mod 26 3 1");
            System.out.println("java HW3 Algebra mod 27 3 1");

            System.out.println("java HW3 Algebra sqrt 1 1");
            System.out.println("java HW3 Algebra sqrt 9 1");
            System.out.println("java HW3 Algebra sqrt 81 1");


            System.out.println("java HW3 StringOps charRunCount \" Phase one  \" e 1");
            System.out.println("java HW3 StringOps charRunCount \" IroN Man  \" n 1");
            System.out.println("java HW3 StringOps charRunCount \" HULK    SMASHHHHHHHHHH\" H 1");
            System.out.println("java HW3 StringOps charRunCount \"Thor Odinson got Stabbed BY LOKI AGaiN \" o 1");
            System.out.println("java HW3 StringOps charRunCount \" CApTAIN     AmeRICA   thE     FiRsT             AVENGER \" S 1");

            System.out.println("java HW3 StringOps lowercase \"            PHASE TWO  \" 1");
            System.out.println("java HW3 StringOps lowercase \"  CApTAIN     AmeRICA AND        The WintER SOLDIER  \" 1");
            System.out.println("java HW3 StringOps lowercase \" AVENGERS ageOFUltron \" 1");
            System.out.println("java HW3 StringOps lowercase \"WE ARE                 GROOOOOOOOOOT\"  1");

            System.out.println("java HW3 StringOps camelcase \"            PHASE THREE  \" 1");
            System.out.println("java HW3 StringOps camelcase \"WAKANDA             FOREVER\" 1");
            System.out.println("java HW3 StringOps camelcase \"     Hello MY     NAme IS KorG aNd     I aM made of ROCKSSSSS             \" 1");
            System.out.println("java HW3 StringOps camelcase \"He   IS a Friend FORM wOrK\" 1");
            System.out.println("java HW3 StringOps camelcase \"    DorMAMMu I have To BARGaIN     \" 1");
            System.out.println("java HW3 StringOps camelcase \"UNDEROOOOS\" 1");
            System.out.println("java HW3 StringOps camelcase \" Where    iS GAmorA      WhO Is GaMOrA    WHY IS gamora  \" 1");
            System.out.println("java HW3 StringOps camelcase \" OHHHH SnaPP \" 1");
            System.out.println("java HW3 StringOps camelcase \"I am InveViteABLE             and I am IRON MAN\" 1");
            System.out.println("java HW3 StringOps camelcase \"SPIDERMANS NAME     IS PETER PARKER \" 1");

            System.out.println("java HW3 StringOps compareTo \"PHASE\" \"Four\" 1");
            System.out.println("java HW3 StringOps compareTo \"agatha\" \"wanda\" 1");
            System.out.println("java HW3 StringOps compareTo \"tobey\" \"andrew\" 1");
            System.out.println("java HW3 StringOps compareTo \"KATEBISHOP\" \"katebishop\" 1");
            System.out.println("java HW3 StringOps compareTo \"cap\" \"captain\" 1");
            System.out.println("java HW3 StringOps compareTo \"ViSion\" \"vis\" 1");
            System.out.println("java HW3 StringOps compareTo \"KiNgPiN\" \"Kingpin\" 1");
            System.out.println("java HW3 StringOps compareTo \"william\" \"willem\" 1");
            System.out.println("java HW3 StringOps compareTo \"Namor\" \"kukulkan\" 1");

            System.out.println("java HW3 StringOps stringToInt \"1\" 1");
            System.out.println("java HW3 StringOps stringToInt \"-1\" 1");
            System.out.println("java HW3 StringOps stringToInt \"-0\" 2");
            System.out.println("java HW3 StringOps stringToInt \"+7\" 1");
            System.out.println("java HW3 StringOps stringToInt \"12346\" 1");
            System.out.println("java HW3 StringOps stringToInt \"-12346\" 1");
            System.out.println("java HW3 StringOps stringToInt \"+12346\" 1");
            System.out.println("java HW3 StringOps stringToInt \"+07533\" 2");
            System.out.println("java HW3 StringOps stringToInt \"-08542\" 2");
            System.out.println("java HW3 StringOps stringToInt \"08542\" 2");

            System.out.println("java HW3 StringOps expand \"G2T11C4A5T1G8C2\" 1");
            System.out.println("java HW3 StringOps expand \"G20T01C4A5C1G8C2\" 1");
            System.out.println("java HW3 StringOps expand \"T2A1C4A5T1G3C2\" 1");
            System.out.println("java HW3 StringOps expand \"G2A3G8C2\" 1");
            System.out.println("java HW3 StringOps expand \"A2T3G2A1T3C2\" 1");

            System.out.println("java HW3 Anagram preProcess \"This IS MY Spot\" 1");
            System.out.println("java HW3 Anagram preProcess \"Knock knock knock Penny KNOCK knOCK kNOck PeNNy knOCK kNOCk KNocK pEnnY\" 1");
            System.out.println("java HW3 Anagram preProcess \"Bazinga\" 1");

            System.out.println("java HW3 Anagram isAnagram \"cat\" \"act\" 2");
            System.out.println("java HW3 Anagram isAnagram \"cat\" \"ACT\" 2");
            System.out.println("java HW3 Anagram isAnagram \"Dumbeldore\" \"Dumbell\" 2");
            System.out.println("java HW3 Anagram isAnagram \"Griffin Dor\" \"Griffindor\" 2");
            System.out.println("java HW3 Anagram isAnagram \"Tom Marvolo Riddle\" \"I Am The Dark Lord\" 2");
            System.out.println("java HW3 Anagram isAnagram \"Tom Marvolo Riddle\" \"I Am Lord Voldermort\" 2");

            System.out.println("java HW3 Anagram randomAnagram \"cat\" 1");
            System.out.println("java HW3 Anagram randomAnagram \"Harry JAMES poTTER\" 1");
            System.out.println("java HW3 Anagram randomAnagram \"AlBus PerCiVaL WuLFRic BrIAn DumBLEdORe\" 1");
            
        } else if (command.equals("tests2")) {
            //The tests for MOODLE:
            System.out.println("java HW3 Algebra plus 1 0 1");
            System.out.println("java HW3 Algebra plus 124271 247811 1");

            System.out.println("java HW3 Algebra minus 1 0 1");
            System.out.println("java HW3 Algebra minus 12 131 1");

            System.out.println("java HW3 Algebra times 11 0 1");
            System.out.println("java HW3 Algebra times 11 1 1");
            System.out.println("java HW3 Algebra times 1278 12 1");

            System.out.println("java HW3 Algebra pow 13 0 1");
            System.out.println("java HW3 Algebra pow 13 1 1");
            System.out.println("java HW3 Algebra pow 1 183 1");
            System.out.println("java HW3 Algebra pow 12 2 1");
            System.out.println("java HW3 Algebra pow 2 10 1");

            System.out.println("java HW3 Algebra div 27 1 1");
            System.out.println("java HW3 Algebra div 26 3 1");
            System.out.println("java HW3 Algebra div 27 3 1");
            System.out.println("java HW3 Algebra div 28 3 1");

            System.out.println("java HW3 Algebra mod 25 3 1");
            System.out.println("java HW3 Algebra mod 26 3 1");
            System.out.println("java HW3 Algebra mod 27 3 1");

            System.out.println("java HW3 Algebra sqrt 1 1");
            System.out.println("java HW3 Algebra sqrt 9 1");
            System.out.println("java HW3 Algebra sqrt 81 1");

            System.out.println("java HW3 StringOps charRunCount \" Phase one  \" e 1");
            System.out.println("java HW3 StringOps charRunCount \" IroN Man  \" n 1");
            System.out.println("java HW3 StringOps charRunCount \" HULK    SMASHHHHHHHHHH\" H 1");
            System.out.println("java HW3 StringOps charRunCount \"Thor Odinson got Stabbed BY LOKI AGaiN \" o 1");
            System.out.println("java HW3 StringOps charRunCount \" CApTAIN     AmeRICA   thE     FiRsT             AVENGER \" S 1");

            System.out.println("java HW3 StringOps lowercase \"            PHASE TWO  \" 1");
            System.out.println("java HW3 StringOps lowercase \"  CApTAIN     AmeRICA AND        The WintER SOLDIER  \" 1");
            System.out.println("java HW3 StringOps lowercase \" AVENGERS ageOFUltron \" 1");
            System.out.println("java HW3 StringOps lowercase \"WE ARE                 GROOOOOOOOOOT\"  1");

            System.out.println("java HW3 StringOps camelcase \"            PHASE THREE  \" 1");
            System.out.println("java HW3 StringOps camelcase \"WAKANDA             FOREVER\" 1");
            System.out.println("java HW3 StringOps camelcase \"     Hello MY     NAme IS KorG aNd     I aM made of ROCKSSSSS             \" 1");
            System.out.println("java HW3 StringOps camelcase \"He   IS a Friend FORM wOrK\" 1");
            System.out.println("java HW3 StringOps camelcase \"    DorMAMMu I have To BARGaIN     \" 1");
            System.out.println("java HW3 StringOps camelcase \"UNDEROOOOS\" 1");
            System.out.println("java HW3 StringOps camelcase \" Where    iS GAmorA      WhO Is GaMOrA    WHY IS gamora  \" 1");
            System.out.println("java HW3 StringOps camelcase \" OHHHH SnaPP \" 1");
            System.out.println("java HW3 StringOps camelcase \"I am InveViteABLE             and I am IRON MAN\" 1");
            System.out.println("java HW3 StringOps camelcase \"SPIDERMANS NAME     IS PETER PARKER \" 1");

            System.out.println("java HW3 StringOps compareTo \"PHASE\" \"Four\" 1");
            System.out.println("java HW3 StringOps compareTo \"agatha\" \"wanda\" 1");
            System.out.println("java HW3 StringOps compareTo \"tobey\" \"andrew\" 1");
            System.out.println("java HW3 StringOps compareTo \"KATEBISHOP\" \"katebishop\" 1");
            System.out.println("java HW3 StringOps compareTo \"cap\" \"captain\" 1");
            System.out.println("java HW3 StringOps compareTo \"ViSion\" \"vis\" 1");
            System.out.println("java HW3 StringOps compareTo \"KiNgPiN\" \"Kingpin\" 1");
            System.out.println("java HW3 StringOps compareTo \"william\" \"willem\" 1");
            System.out.println("java HW3 StringOps compareTo \"Namor\" \"kukulkan\" 1");

            System.out.println("java HW3 StringOps stringToInt \"1\" 1");
            System.out.println("java HW3 StringOps stringToInt \"-1\" 1");
            System.out.println("java HW3 StringOps stringToInt \"-0\" 2");
            System.out.println("java HW3 StringOps stringToInt \"+7\" 1");
            System.out.println("java HW3 StringOps stringToInt \"12346\" 1");
            System.out.println("java HW3 StringOps stringToInt \"-12346\" 1");
            System.out.println("java HW3 StringOps stringToInt \"+12346\" 1");
            System.out.println("java HW3 StringOps stringToInt \"+07533\" 2");
            System.out.println("java HW3 StringOps stringToInt \"-08542\" 2");
            System.out.println("java HW3 StringOps stringToInt \"08542\" 2");

            System.out.println("java HW3 StringOps expand \"G2T11C4A5T1G8C2\" 1");
            System.out.println("java HW3 StringOps expand \"G20T01C4A5C1G8C2\" 1");
            System.out.println("java HW3 StringOps expand \"T2A1C4A5T1G3C2\" 1");
            System.out.println("java HW3 StringOps expand \"G2A3G8C2\" 1");
            System.out.println("java HW3 StringOps expand \"A2T3G2A1T3C2\" 1");

            System.out.println("java HW3 Anagram preProcess \"This IS MY Spot\" 1");
            System.out.println("java HW3 Anagram preProcess \"Knock knock knock Penny KNOCK knOCK kNOck PeNNy knOCK kNOCk KNocK pEnnY\" 1");
            System.out.println("java HW3 Anagram preProcess \"Bazinga\" 1");

            System.out.println("java HW3 Anagram isAnagram \"cat\" \"act\" 2");
            System.out.println("java HW3 Anagram isAnagram \"cat\" \"ACT\" 2");
            System.out.println("java HW3 Anagram isAnagram \"Dumbeldore\" \"Dumbell\" 2");
            System.out.println("java HW3 Anagram isAnagram \"Griffin Dor\" \"Griffindor\" 2");
            System.out.println("java HW3 Anagram isAnagram \"Tom Marvolo Riddle\" \"I Am The Dark Lord\" 2");
            System.out.println("java HW3 Anagram isAnagram \"Tom Marvolo Riddle\" \"I Am Lord Voldermort\" 2");

            System.out.println("java HW3 Anagram randomAnagram \"cat\" 1");
            System.out.println("java HW3 Anagram randomAnagram \"Harry JAMES poTTER\" 1");
            System.out.println("java HW3 Anagram randomAnagram \"AlBus PerCiVaL WuLFRic BrIAn DumBLEdORe\" 1");

        } else if (command.equals("Algebra")) {
            //Test Algebra
            String testName = args[1];
            switch (testName) {
                case "plus": {
                    int x1 = Integer.parseInt(args[2]);
                    int x2 = Integer.parseInt(args[3]);
                    plusTest(x1, x2, false);
                    break;
                }
                case "minus": {
                    int x1 = Integer.parseInt(args[2]);
                    int x2 = Integer.parseInt(args[3]);
                    minusTest(x1, x2, false);
                    break;
                }
                case "times": {
                    int x1 = Integer.parseInt(args[2]);
                    int x2 = Integer.parseInt(args[3]);
                    timesTest(x1, x2, false);
                    break;
                }
                case "pow": {
                    int x1 = Integer.parseInt(args[2]);
                    int x2 = Integer.parseInt(args[3]);
                    powTest(x1, x2, false);
                    break;
                }
                case "div": {
                    int x1 = Integer.parseInt(args[2]);
                    int x2 = Integer.parseInt(args[3]);
                    divTest(x1, x2, false);
                    break;
                }
                case "mod": {
                    int x1 = Integer.parseInt(args[2]);
                    int x2 = Integer.parseInt(args[3]);
                    modTest(x1, x2, false);
                    break;
                }
                case "sqrt":
                    int x = Integer.parseInt(args[2]);
                    sqrtTest(x, false);
                    break;
            }

        } else if (command.equals("StringOps")) {
            //Test StringOps
            String testName = args[1];
            switch (testName) {
                case "expand": {
                    expandTest(args[2], false);
                    break;
                }
                case "camelcase": {
                    camelcaseTest(args[2], false);
                    break;
                }
                case "charRunCount": {
                    char c = args[3].charAt(0);
                    charRunCountTest(args[2], c, false);
                    break;
                }
                case "lowercase": {
                    lowerCaseTest(args[2], false);
                    break;
                }
                case "compareTo": {
                    compareToTest(args[2],args[3], false);
                    break;
                }
                case "stringToInt": {
                    stringToIntTest(args[2], false);
                    break;
                }
            }
        } else if (command.equals("Anagram")) {
            //Test Anagram
            String testName = args[1];
            switch (testName) {
                case "isAnagram": {
                    isAnagramTest(args[2],args[3], false);
                    break;
                }
                case "preProcess": {
                    preProcessTest(args[2], false);
                    break;
                }
                case "randomAnagram": {
                    randomAnagramTest(args[2], false);
                    break;
                }
            }
        }
    }



    ////////////////////
    // Algebra - plus
    // TEST plus TEST
    public static void plusTest(int x1, int x2, boolean failAnyway) {
        String testName = "plus test in Algebra.java";
        int studentSolution = -1;
        try {
            studentSolution = Algebra.plus(x1, x2);
        }
        catch(Exception e) {
            failAnyway = true;
        }
        int solution = plusSolution(x1, x2);
        boolean test = solution == studentSolution;

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nFirst Int = " + x1
                    +"\nSecond Int = " + x2
                    +"\nCorrect solution:\n" + solution
                    +"\nYour solution: " + studentSolution;
            printGETFEED(msg);
        }
    }

    // Returns x1 + x2.
    // Assumption: x1 and x2 are nonnegative.
    public static int plusSolution(int x1, int x2) {
        int result = x1;
        for (int count = 0; count < x2; count++) {
            result++;
        } 
        return result;
    }

    ////////////////////
    // Algebra - minus
    // TEST minus TEST
    public static void minusTest(int x1, int x2, boolean failAnyway) {
        String testName = "minus test in Algebra.java";
        int studentSolution = -1;
        try {
            studentSolution = Algebra.minus(x1, x2);
        }
        catch(Exception e) {
            failAnyway = true;
        }
        int solution = minusSolution(x1, x2);
        boolean test = solution == studentSolution;

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nFirst Int = " + x1
                    +"\nSecond Int = " + x2
                    +"\nCorrect solution:\n" + solution
                    +"\nYour solution: " + studentSolution;
            printGETFEED(msg);
        }
    }

    // Returns x1 - x2.
    // Assumption: x1 and x2 are nonnegative, and x1 >= x2.
    public static int minusSolution(int x1, int x2) {
        int result = x1;
        for (int count = 0; count < x2; count++) {
            result--;
        } 
        return result;
    }

    ////////////////////
    // Algebra - times
    // TEST times TEST
    public static void timesTest(int x1, int x2, boolean failAnyway) {
        String testName = "times test in Algebra.java";
        int studentSolution = -1;
        try {
            studentSolution = Algebra.times(x1, x2);
        }
        catch(Exception e) {
            failAnyway = true;
        }
        int solution = timesSolution(x1, x2);
        boolean test = solution == studentSolution;

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nFirst Int = " + x1
                    +"\nSecond Int = " + x2
                    +"\nCorrect solution:\n" + solution
                    +"\nYour solution: " + studentSolution;
            printGETFEED(msg);
        }
    }

    // Returns x1 * x2.
    public static int timesSolution(int x1, int x2) {
        int result = 0;
        for (int count = 0; count < x2; count++) {
            result = plusSolution(result,x1);
        }
        return result;
    }

    ////////////////////
    // Algebra - pow
    // TEST pow TEST
    public static void powTest(int x1, int x2, boolean failAnyway) {
        String testName = "pow test in Algebra.java";
        int studentSolution = -1;
        try {
            studentSolution = Algebra.pow(x1, x2);
        }
        catch(Exception e) {
            failAnyway = true;
        }
        int solution = powSolution(x1, x2);
        boolean test = solution == studentSolution;

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nFirst Int = " + x1
                    +"\nSecond Int = " + x2
                    +"\nCorrect solution:\n" + solution
                    +"\nYour solution: " + studentSolution;
            printGETFEED(msg);
        }
    }

    public static int powSolution(int x, int n) {
        int result = 1;
        for (int count = 0; count < n; count++) {
            result = timesSolution(result,x);
        }
        return result;
    }

    ////////////////////
    // Algebra - div
    // TEST div TEST
    public static void divTest(int x1, int x2, boolean failAnyway) {
        String testName = "div test in Algebra.java";
        int studentSolution = -1;
        try {
            studentSolution = Algebra.div(x1, x2);
        }
        catch(Exception e) {
            failAnyway = true;
        }
        int solution = divSolution(x1, x2);
        boolean test = solution == studentSolution;

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nFirst Int = " + x1
                    +"\nSecond Int = " + x2
                    +"\nCorrect solution:\n" + solution
                    +"\nYour solution: " + studentSolution;
            printGETFEED(msg);
        }
    }

    // Returns x1 / x2 (integer division).
    // Assumption: x1 is nonnegative, x2 is positive.
    public static int divSolution(int x1, int x2) {
        int result = 0;
        int numerator = x2;
        while (x1 >= x2){
            x2 = plusSolution(x2, numerator);
            result++;
        }
        return result;
    }

    ////////////////////
    // Algebra - mod
    // TEST mod TEST
    public static void modTest(int x1, int x2, boolean failAnyway) {
        String testName = "mod test in Algebra.java";
        int studentSolution = -1;
        try {
            studentSolution = Algebra.mod(x1, x2);
        }
        catch(Exception e) {
            failAnyway = true;
        }
        int solution = modSolution(x1, x2);
        boolean test = solution == studentSolution;

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nFirst Int = " + x1
                    +"\nSecond Int = " + x2
                    +"\nCorrect solution:\n" + solution
                    +"\nYour solution: " + studentSolution;
            printGETFEED(msg);
        }
    }

    // Returns x1 % x2
    public static int modSolution(int x1, int x2) {
        return minusSolution(x1,timesSolution(x2,divSolution(x1,x2)));
    }

    ////////////////////
    // Algebra - sqrt
    // TEST sqrt TEST
    public static void sqrtTest(int x, boolean failAnyway) {
        String testName = "sqrt test in Algebra.java";
        int studentSolution = -1;
        try {
            studentSolution = Algebra.sqrt(x);
        }
        catch(Exception e) {
            failAnyway = true;
        }
        int solution = sqrtSolution(x);
        boolean test = solution == studentSolution;

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nInt = " + x
                    +"\nCorrect solution:\n" + solution
                    +"\nYour solution: " + studentSolution;
            printGETFEED(msg);
        }
    }

    // Returns the integer part of sqrt(x)
    // Assumption: x >= 1.
    public static int sqrtSolution(int x) {
        int result = 1;
        while (timesSolution(result,result) <= x) {
            result++;
        }
        return --result;
    }

    ////////////////////
    // StringOps - charRunCount
    // TEST charRunCount TEST
    public static void charRunCountTest(String str, char c, boolean failAnyway) {
        String testName = "charRunCount test in StringOps.java";
        int studentSolution = -1;
        try {
            studentSolution = StringOps.charRunCount(str, c);
        }
        catch(Exception e) {
            failAnyway = true;
        }
        int solution = charRunCountSolution(str, c);
        boolean test = solution == studentSolution;

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nString = " + str
                    +"\nchar = " + c
                    +"\nCorrect solution:\n" + solution
                    +"\nYour solution: " + studentSolution;
            printGETFEED(msg);
        }
    }

    ////////////////////
    // SOLUTION charRunCount from StringOps.java SOLUTION
    public static int charRunCountSolution(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length() ; i++) {
            count = str.charAt(i) == c ? count + 1 : count;
        }
        return count;
    }

    ////////////////////
    // StringOps - lowerCase
    // TEST lowerCase TEST
    public static void lowerCaseTest(String str, boolean failAnyway) {
        String testName = "lowerCase test in StringOps.java";
        String studentSolution = null;
        try {
            studentSolution = StringOps.lowercase(str);
        }
        catch(Exception e) {
            failAnyway = true;
        }
        String solution = lowerCaseSolution(str);
        boolean test = solution.equals(studentSolution);

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nstr = " + str
                    +"\nCorrect solution:\n" + solution
                    +"\nYour solution: " + studentSolution;
            printGETFEED(msg);
        }
    }
    ////////////////////
    // SOLUTION lowerCase from StringOps.java SOLUTION
    public static String lowerCaseSolution(String str) {
        String result = "";
        for (int i = 0; i < str.length() ; i++) {
            result += (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') ? (char) (str.charAt(i) + 32) :  str.charAt(i);
        }
        return result;
    }
        ////////////////////
    // StringOps - camelcase
    // TEST camelcase TEST
    public static void camelcaseTest(String str, boolean failAnyway) {
        String testName = "camelcase test in StringOps.java";
        String studentSolution = null;
        try {
            studentSolution = StringOps.camelcase(str);
        }
        catch(Exception e) {
            failAnyway = true;
        }
        String solution = camelcaseSolution(str);
        boolean test = solution.equals(studentSolution);

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nstr = " + str
                    +"\nCorrect solution:\n" + solution
                    +"\nYour solution: " + studentSolution;
            printGETFEED(msg);
        }
    }
    ////////////////////
    // SOLUTION camelcase from StringOps.java SOLUTION
    public static String camelcaseSolution(String str){
        String captialized = captializeWord(str);
        String noSpaceCapped = removeSpaces(captialized);
        return letterToLower(noSpaceCapped.charAt(0)) + noSpaceCapped.substring(1);
    }
    
    private static String captializeWord(String str){
        String res = "" + letterToUpper(str.charAt(0));
        boolean flag = isLetter(str.charAt(0));             // on word
        for (int i = 1; i < str.length(); i++) {
            if (isLetter(str.charAt(i))){                  
                res += !flag ? letterToUpper(str.charAt(i)) : letterToLower(str.charAt(i));
            }
            flag = isLetter(str.charAt(i));
        }
        return res;
    }
    
    private static char letterToUpper(char chr){
        return !(chr >= 'a' && chr <= 'z') ? chr : (char) (chr - ' ');
    }

    private static char letterToLower(char chr){
        return !(chr >= 'A' && chr <= 'Z') ? chr : (char) (chr + ' ');
    }
    private static boolean isLetter(char chr){
        return (chr >= 'a' && chr <= 'z') || (chr >= 'A' && chr <= 'Z');
    }
    private static String removeSpaces(String str){
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            res += str.charAt(i) != ' ' ? str.charAt(i) : "";
        }
        return res;
    }

    ////////////////////
    // StringOps - compareTo
    // TEST compareTo TEST
    public static void compareToTest(String str1, String str2, boolean failAnyway) {
        String testName = "compareTo test in StringOps.java";
        int studentSolution = 5;
        try {
            studentSolution = StringOps.compareTo(str1, str2);
        }
        catch(Exception e) {
            failAnyway = true;
        }
        int solution = compareToSolution(str1, str2);
        boolean test = solution == studentSolution;

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nstr1 = " + str1
                    +"\nstr2 = " + str2
                    +"\nCorrect solution:\n" + solution
                    +"\nYour solution: " + studentSolution;
            printGETFEED(msg);
        }
    }
    ////////////////////
    // SOLUTION compareTo from StringOps.java SOLUTION
    public static int compareToSolution(String str1, String str2){
        int minLength = Math.min(str1.length(),str2.length());
        String strLower1 = lowerCaseSolution(str1);
        String strLower2 = lowerCaseSolution(str2);
        for (int i = 0; i < minLength; i++) {
            if (strLower1.charAt(i) != strLower2.charAt(i)){
                return strLower1.charAt(i) < strLower2.charAt(i) ? -1 : 1;
            }
        }
        return str1.length() == str2.length() ? 0 : (str1.length() - str2.length()) / Math.abs(str1.length() - str2.length());
    }
    
    ////////////////////
    // StringOps - stringToInt
    // TEST stringToInt TEST
    public static void stringToIntTest(String str, boolean failAnyway) {
        String testName = "stringToInt test in StringOps.java";
        int studentSolution = 0;
        try {
            studentSolution = StringOps.stringToInt(str);
        }
        catch(Exception e) {
            failAnyway = true;
        }
        int solution = stringToIntSolution(str);
        boolean test = solution == studentSolution;

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nstr = " + str
                    +"\nCorrect solution:\n" + solution
                    +"\nYour solution: " + studentSolution;
            printGETFEED(msg);
        }
    }

    ////////////////////
    // SOLUTION stringToInt from StringOps.java SOLUTION
    public static int stringToIntSolution(String str) {
        int sign = str.charAt(0) == '-' ? -1 : 1;
        String numStrNoSign = str;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            numStrNoSign = str.substring(1);
        }
        int sum = 0;
        for (int i = 0; i < numStrNoSign.length(); i++) {
            int digit = numStrNoSign.charAt(i) - '0';
            sum += digit * Math.pow(10, ((numStrNoSign.length() - 1) - i));
        }
        return sum * sign;
    }

    ////////////////////
    // StringOps - expand
    // TEST expand TEST
    public static void expandTest(String str, boolean failAnyway) {
        String testName = "expand test in StringOps.java";
        String studentSolution = null;
        try {
            studentSolution = StringOps.expand(str);
        }
        catch(Exception e) {
            failAnyway = true;
        }
        String solution = expandSolution(str);
        boolean test = solution.equals(studentSolution);

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nstr = " + str
                    +"\nCorrect solution:\n" + solution
                    +"\nYour solution: " + studentSolution;
            printGETFEED(msg);
        }
    }

    ////////////////////
    // SOLUTION expand from StringOps.java SOLUTION
    public static String expandSolution(String str) {
        String res = "";
        int i = 0;
        while (i < str.length() - 1) {
            char currChar = str.charAt(i);
            i++;
            int j = i;
            while (str.charAt(j) > 47 && str.charAt(j) < 58){
                j++;
                if (j == str.length()){
                    break;
                }
            }
            int times = Integer.parseInt(str.substring(i,j));
            for (int k = 0 ; k < times ; k++) {
                res += currChar;
            }

            i = j;
        }
        return res;
    }



    ////////////////////
    // Anagram - isAnagram
    // TEST isAnagram TEST
    public static void isAnagramTest(String str1, String str2, boolean failAnyway) {
        String testName = "isAnagram test in Anagram.java";
        boolean studentSolution = false;
        try {
            studentSolution = Anagram.isAnagram(str1, str2);
        }
        catch(Exception e) {
            failAnyway = true;
        }
        boolean solution = isAnagramSolution(str1, str2);
        boolean test = solution == studentSolution;

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nFirst string = " + str1
                    +"\nSecond string = " + str2
                    +"\nCorrect solution:\n" + solution
                    +"\nYour solution: " + studentSolution;
            printGETFEED(msg);
        }
    }

    ////////////////////
    // SOLUTION isAnagram from Anagram.java SOLUTION
    public static boolean isAnagramSolution(String str1, String str2) {
        str1 = preProcessSolution(str1);
        str2 = preProcessSolution(str2);
        if (str1.length() != str2.length()){
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) == c) {
                    count1++;
                }
                if (str2.charAt(j) == c) {
                    count2++;
                }
            }
            if (count1 != count2) {
                return false;
            }
        }
        return true;
    }

    ////////////////////
    // Anagram - preProcess
    // TEST preProcess TEST
    public static void preProcessTest(String str, boolean failAnyway) {
        String testName = "preProcess test in Anagram.java";
        String studentSolution = null;
        try {
            studentSolution = Anagram.preProcess(str);
        }
        catch(Exception e) {
            failAnyway = true;
        }
        String solution = preProcessSolution(str);
        boolean test = solution.equals(studentSolution);

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nString = " + str
                    +"\nCorrect solution:\n" + solution
                    +"\nYour solution: " + studentSolution;
            printGETFEED(msg);
        }
    }

    ////////////////////
    // SOLUTION preProcess from Anagram.java SOLUTION
    public static String preProcessSolution(String str) {
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                ans += c;
            }
            if (c >= 'A' && c <= 'Z') {
                ans += (char)(c - ('A' - 'a'));
            }
        }
        return ans;
    }

    ////////////////////
    // Anagram - randomAnagram
    // TEST randomAnagram TEST
    public static void randomAnagramTest(String str, boolean failAnyway) {
        String testName = "randomAnagram test in Anagram.java";
        String studentSolution1 = null;
        String studentSolution2 = null;
        try {
            studentSolution1 = Anagram.randomAnagram(str);
            studentSolution2 = Anagram.randomAnagram(str);
        }
        catch(Exception e) {
            failAnyway = true;
        }

        boolean test = isAnagramSolution(str, studentSolution1) &&
                       isAnagramSolution(str, studentSolution2) &&
                       isAnagramSolution(studentSolution1, studentSolution2);

        if (!test || failAnyway) {
            String msg =  testName + " failed with arguments:"
                    +"\nString = " + str;
            printGETFEED(msg);
        }
    }


    ////////////////////
    // SOLUTION randomAnagram from Anagram.java SOLUTION
    public static String randomAnagramSolution(String str) {
        String ans = "";
        while (str.length() > 0) {
            int rand = (int)(str.length() * Math.random());
            ans += str.charAt(rand);
            str = str.substring(0, rand) + str.substring(rand + 1);
        }
        return ans;
    }



    ///////////////////////////////////
    // Print to GETFEED
    public static void printGETFEED(String msg) {
        System.out.println("GETFEED: " + msg + "\n\n:GETFEED");
    }

}