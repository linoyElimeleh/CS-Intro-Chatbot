public class ReviewProblemsHints {

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
    // (Integer.ParseInt, Double.parseDouble etc.)
    // String functions allowed in question: 
    // 1. str.substring(int start)
    // 2. str.substring(int start, int end)
    // 3. str.charAt(int index)
    // 4. str.length()
    // 5. str.indexOf(char ch)

    // impelemntation tips:
    /// 1. Use ASCII

    // impelemntation steps:
    /// 1. Declare char 'op' (inital value = '') and int 'opIndex' (inital value = -1) 
    /// 2. Go over the string with a for loop (i = 0, i < length, i++)
    ///     2.1. Take current char with charAt(i), 
    ///     2.2. Using indexOf with the current char and a string of 
    ///          all math ops, check for appearance by comparing to -1.
    ///     2.3. If found:
    ///          2.3.1. Put current i in 'opIndex'.
    ///          2.3.2. Using the result from step 2.2, charAt(int i), and a string all math ops to find the op needed, them and put in 'op'.
    ///          2.3.3. Break for loop
    ///     2.4  Otherwise, move to next iteration
    /// 2. use substring from 0 to 'opIndex', to get the first number and put it in String 'strNum1'
    /// 3. use substring from 'opIndex' + 1, to get the second number and put it in String 'strNum2'
    /// 4. Declare int variable (inital value = 0) 
    /// 5. Go over 'strNum1' with for loop (i = 0, i < length, i++)
    ///    5.1. take current char and convert it into an int using ASCII formula to the respectable int.
    ///    5.2. multiply the output of step 5.1 with Math.pow(10, length - i - 1); 
    /// 6. Repeat steps 4-5 for 'strNum2'
    /// 7. Use swtich case on 'op', and build a case for every op that calcs the op between the 2 numbers
    /// 8. return the result of 7.  

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

    // impelemntation steps:
    /// 1. captilaze every word, and lower rest
    ///    at the start consider 2 cases, started on letter, started on space.     
    ///    when build a loop start from index 1, and condsider 4 different cases 
    ///    a. previous was space, current is space -> don't matter, concat to sol & move to next
    ///    b. previous was space, current is letter -> change to upper case, concat to sol & move to next
    ///    c. previous was letter, current is space -> don't matter, concat to sol & move to next
    ///    d. previous was letter, current is letter -> change to lower case, concat to sol & move to next  
    /// 2. remove spaces on 1 result.
    /// 3. lowercase the first char. 
    public static String toCamelCase (String str){
        return "";
    }

    //The function 'secondLargestElement' is a function that takes an array of integers and returns the second largest number.
    //In case there are duplicates at max value dont take the max number
    // Example: {1,2,2,-1} ---> 1
    // Implementation tips:
    // 1. Initilaze an int with initial value Integer.MIN_VALUE
    // 2. Iterate over array to find value of max value. 
    // 3. Initilaze another int with initial value Integer.MIN_VALUE
    // 4. Iterate over array to find value of 2nd max value (if equals to value of step 2 skip). 
    public static int secondLargestElement (int [] arr) {
        return Integer.MIN_VALUE;
    }


    //The function 'secondLargestElement2' is a function that takes an array of integers and returns the second largest number.
    //In case there are duplicates at max value take the max number
    // Example: {1,2,2,-1} ---> 2
    // Implementation tips:
    // 1. Initilaze an int with initial value -1
    // 2. Iterate over array to find the key in array that holds the max value. 
    // 3. Initilaze an int with initial value -1
    // 4. Iterate over array to find the key in array that holds the 2nd max value (if equals to key of step 2 skip). 
    public static int secondLargestElement2 (int [] arr) {
        return Integer.MIN_VALUE;
    }


    //Write a function that takes a string as input and returns the character that appears the most frequently
    //If there is a tie, return the one which is first in lexicographic order.
    //Example: "character" -> 'c'
    //1. create an int array in size 26 (English AlphaBet)
    //2. for every letter in string find if upper or lower case letter and convert using ASCII formula, then increase the position reltive in the array to letter
    //   'a' -> 0, 'b'-> 1 etc. and increament by 1.
    //3. go over int array to find key of max value then take the index and convert to char
    public static char mostFrequentCharInString (String str){
        return ' ';
    }
    

    //A string is a rotation of another string if one string can be obtained by "rotating" the other. 
    //For example, "abcd" rotated by 2 positions to the right becomes "cdab".
    // The function 'isStringRotation' rotation recieves 2 strings and checks if one is a rotation of the other
    // 1. they must be equal in length..
    // 2. concat 1 to self. 
    // 3. check for substring that equals to the the other one
    public static boolean isStringRotation (String str, String other){
        return false;
    }

    // The function 'longestWordInSentence' recieves a String contains a string of words seperated by a single space
    // And returns the word with the longest length. If there is a tie return the one who appears in 
    // ** A word is defined as a consecutive sequence of letters (both upper and lower). 
    // 1. Initialize 2 String variables, both initialize to "". 1 named 'maxLengthString' the other 'currLengthString'
    // 2. Iterate over str
    //    2.1 if cur char is a letter, concat it to 'currLengthString'.
    //    2.2 if cur char is a space, check lengths 'currLengthString' and 'maxLengthString'. 
    //        if 'currLengthString' is equal or bigger in length, put it as 'maxLengthString'.
    // 3. return 'maxLengthString'.
    public static String longestWordInSentence (String str){
        return "";
    }
}