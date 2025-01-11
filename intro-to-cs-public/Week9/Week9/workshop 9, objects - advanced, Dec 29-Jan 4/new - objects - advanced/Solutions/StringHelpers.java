public class StringHelpers {
    public static String captializeWords(String str) {
        String res = "" + letterToUpper(str.charAt(0));
        boolean flag = isLetter(str.charAt(0)); // on word
        for (int i = 1; i < str.length(); i++) {
            if (isLetter(str.charAt(i))) {
                res += !flag ? letterToUpper(str.charAt(i)) : letterToLower(str.charAt(i));
            } else {
                res += str.charAt(i);
            }
            flag = isLetter(str.charAt(i));
        }
        return res;
    }

    public static char letterToUpper(char chr) {
        return ('a' <= chr && chr <= 'z') ? (char) (chr - 'a' + 'A') : chr;
    }

    public static char letterToLower(char chr) {
        return ('A' <= chr && chr <= 'Z') ? (char) (chr - 'A' + 'a') : chr;
    }

    public static boolean isLetter(char chr) {
        return ('a' <= chr && chr <= 'z') || ('A' <= chr && chr <= 'Z');
    }
}
