public class RomanToInt {
    /**
     * 
     * Roman numerals are represented by seven different symbols: "I", "V", "X", "L", "C", "D" and "M".
     *  Symbol |  Value
     * -----------------
     *   "I"   |    1
     *   "V"   |    5
     *   "X"   |   10
     *   "L"   |   50
     *   "C"   |  100
     *   "D"   |  500
     *   "M"   | 1000
     * 
     * For Example, 
     *      -> 2 is written as "II" in Roman numeral just two ones ("I") added together.
     *      -> 12 is written as "XII", which is 10 + 1 + 1 -> "X" + "I" + "I".
     *      -> 28 is written as "XXVIII", which is 10 + 10 + 5 + 1 + 1 + 1 -> "X" + "X" + "V" + "I" + "I" + "I".
     * 
     * Roman numerals are usually written largest to smallest from left to right.
     * However, the numeral for 4 is not "IIII". Instead, the number 4 is written as "IV". 
     * Because we subtract, the 1 is before the 5 we subtract to make 4.
     * The same principle applies to the number 9, which is written as "IX". There are six instances where subtraction is used:
     *      -> "I" can be placed before "V" (5) or "X" (10) to make 4 and 9, respectively. (4 = "IV", 9 = "IX")
     *      -> "X" can be placed before "L" (50) or "C" (100) to make 40 and 90, respectively. (40 = "XL", 90 = "XC")
     *      -> "C" can be placed before "D" (500) or "M" (1000) to make 400 and 900, respectively. (400 = "CD", 900 = "CM")
     * 
     * Exmples:
     *      -> 9 is written as "IX", which is 10 - 1 -> "IX"
     *      -> 19 is written as "XIX", which is 10 + (10 - 1) -> "X" + "IX"
     *      -> 44 is written as "XLIV", which is (50 - 10) + 5 - 1 -> "XL" + "IV".
     *      -> 1994 is written as "MCMXCIV", which is 1000 + (1000 - 100) + (100 - 10) + (5 - 1) -> "M" + "CM" + "XC" + "IV".
     *  
     * Given a roman numeral as string, convert it to an integer.
     *      -> Assume that the string is UPPER CASE
     *      -> Assume that the string is a valid roman number
     *      -> Assume that the value of the roman number is in the range of 1-3999
     */
    public static void main(String[] args) {
        
    }
}
