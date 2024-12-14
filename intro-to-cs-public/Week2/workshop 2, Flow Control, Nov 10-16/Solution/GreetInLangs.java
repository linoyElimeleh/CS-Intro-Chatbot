public class GreetInLangs {
    /**
     * Hebrew                    -> "Shalom" 
     * English (also as Default) -> "Hello"
     * German                    -> "Guten Tag"
     * French                    -> "Bonjour"
     * Italian                   -> "Ciao"
     * Spanish                   -> "Hola"
     */

     public static void main(String[] args) {
        String language = args[0];
        String greeting = "";
        switch (language) {
            case "English":
                greeting = "Hello";
                break;
            case "Hebrew":
                greeting = "Shalom";
                break;
            case "German":
                greeting = "Guten Tag";
                break;
            case "French":  
                greeting = "Bonjour";
                break;
            case "Italian":
                greeting = "Ciao";
                break;
            case "Spanish":
                greeting = "Hola";
                break;
            default:
                greeting = "Hello";
                break;
        }
        System.out.println(greeting);
     }
}
