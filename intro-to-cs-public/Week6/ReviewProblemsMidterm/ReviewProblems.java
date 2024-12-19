public class ReviewProblems {
    // The function "calcSimpleEquation", receives a string which contains only digits
    // ('0','1', .... , '9'), and a single mathematical operator '+','-','/','*','%'.
    // The string represent an equation between 2 positive numbers. 
    //
    // The goal in the question is to get the mathematical result of applying the operation
    // on the 2 numbers in the order they are given. 
    
    // You may assume that:
    // 1. The string consists of 3 or more characters, 2 digits, 1 mathematical op
    // 2. Both the first and last characters are digits
    // 3. Both the output, and value of the positive number will be in int range. 
    // 4. If the op is either '/' or '%' then the value of number after the op, it won't be 0. 
    //    I.E The output is a valid number. ("0/3","0%3" etc are legal)
    // 
    // Examples: 
    /// 1. calcSimpleEquation("405+1902");      // 2307
    /// 2. calcSimpleEquation("18/9");          // 2
    /// 3. calcSimpleEquation("19/9");          // 2
    /// 4. calcSimpleEquation("20934-32981");   // -12047
    /// 5. calcSimpleEquation("30421*2");       // 60842
    /// 6. calcSimpleEquation("3179%61");       // 7
    /// 7. calcSimpleEquation("0/7");           // 0

    // During this question you are not allowed to use any Parsing functions 
    // (Integer.ParseInt, Double.parseDouble etc.) or any other coverting ascii functions
    // String functions allowed in question: 
    // 1. str.substring(int start)
    // 2. str.substring(int start, int end)
    // 3. str.charAt(int index)
    // 4. str.length()
    // 5. str.indexOf(char ch)

    // impelemntation tips:
    /// 1. use ASCII 
    
    // impelemntation steps (general):
    /// 1. Find the op, and position in original string
    /// 2. split the orignal string to 2 stringNumbers without the op.
    /// 3. convert both stringNumbers with ASCII
    /// 4. Calc op on two numbers. 
    public static int calcSimpleEquation (String str){
        return -1;
    }

    //The function 'toCamelCase' receives as an input String (containing only letters and spaces) and returns the original string 
    // but changes all the words to camelCase format. quick reminder:
    // 1.	The first word should be lower case only
    // 2.	Every new word after it should start with UPPER case, and the rest should be lower case.
    // 3.	There are no spaces between words.

    
    // During this question you are not allowed to any other coverting ascii functions (toLowerCase, toUpperCase)
    // String functions allowed in question: 
    // 1. str.substring(int start)
    // 2. str.substring(int start, int end)
    // 3. str.charAt(int index)
    // 4. str.length()
    // 5. str.indexOf(char ch)
    
    // impelemntation tips:
    /// 1. Use ASCII
    public static String toCamelCase (String str){
        return "";
    }

    //The function 'secondLargestElement' is a function that takes an array of integers and returns the second largest number.
    //In case there are duplicates at max value dont take the max number
    // Example: {1,2,2,-1} ---> 1
    public static int secondLargestElement (int [] arr) {
        return Integer.MIN_VALUE;
    }


    //The function 'secondLargestElement2' is a function that takes an array of integers and returns the second largest number.
    //In case there are duplicates at max value take the max number
    // Example: {1,2,2,-1} ---> 2
    public static int secondLargestElement2 (int [] arr) {
        return Integer.MIN_VALUE;
    }


    //Write a function that takes a string as input and returns the character that appears the most frequently
    //If there is a tie, return the one which is first in lexicographic order.
    //Example: "character" -> 'c'
    // During this question you are not allowed to any other coverting ascii functions (toLowerCase, toUpperCase etc.)
    public static char mostFrequentCharInString (String str){
        return ' ';
    }
    

    //A string is a rotation of another string if one string can be obtained by "rotating" the other. 
    //For example, "abcd" rotated by 2 positions to the right becomes "cdab".
    // The function 'isStringRotation' rotation recieves 2 strings and checks if one is a rotation of the other
    // String functions allowed in question: 
    // 1. str.substring(int start)
    // 2. str.substring(int start, int end)
    // 3. str.charAt(int index)
    // 4. str.length()
    // 5. str.equals(String other)
    public static boolean isStringRotation (String str, String other){
        return false;
    }

    // The function 'longestWordInSentence' recieves a String contains a string of words seperated by a single space
    // And returns the word with the longest length. If there is a tie return the one who appears in 
    // ** A word is defined as a consecutive sequence of letters (both upper and lower). 
    // 1. str.charAt(int index)
    // 2. str.length() 
    // You dont need more .. 
    public static String longestWordInSentence (String str){
        return "";
    }
}
