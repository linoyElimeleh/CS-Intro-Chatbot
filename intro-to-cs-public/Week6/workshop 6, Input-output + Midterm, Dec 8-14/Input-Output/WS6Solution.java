public class WS6Solution {
    public static void main(String[] args) {
        // printFirst10Songs();
        // printAllSongs();
        // printAllEminemSongsInFile();
        // printAllTailorSwiftSongsInFile();
        // printDurationAndArtistBySong();
        // printAllSongsOver5Minutes();
        // printAllSongsOver2AndHalfMinutesAndUnder4Minutes();
        printTheArtistWithMostSongs();
    }

    /**
     * The following function prints the first 10 songs from "playlist.txt" 
     * */    
    public static void printFirst10Songs(){
        In in = new In("./playlist.txt");
        for (int i = 0; i < 10; i++) {
            System.out.println(in.readLine());
        }
    }

    /**
     * The following function prints all songs from "playlist.txt" 
     * */    
    public static void printAllSongs(){
        In in = new In("./playlist.txt");
        while (in.hasNextLine()) {
            System.out.println(in.readLine());
        }
    }

    /**
     * The following function prints all songs from 
     * "playlist.txt" which the Artist is 'Eminem' and put it 
     */
    public static void printAllEminemSongsInFile(){
        In in = new In("./playlist.txt");
        while (in.hasNextLine()) {
            String songDetails = in.readLine();
            int commaIndex = songDetails.indexOf(',');
            String artist = songDetails.substring(0, commaIndex);
            if (artist.equals("Eminem")){
                System.out.println(songDetails);
            }
        }
    }

    /**
     * The following function prints all songs from 
     * "playlist.txt" which the Artist is 'Tailor Swift' and put it in a file
     * Named "erasTour.txt"
     * 
     * run commands: "javac WS6Solution.java"
     *               "java WS6Solution > erasTour.txt"
     */
    public static void printAllTailorSwiftSongsInFile(){
        In in = new In("./playlist.txt");
        
        while (in.hasNextLine()) {
            String songDetails = in.readLine();
            int commaIndex = songDetails.indexOf(',');
            String artist = songDetails.substring(0, commaIndex);
            if (artist.equals("Taylor Swift")){
                StdOut.println(songDetails);
            }
        }
    }

    /**
     * The following function recieves a Song name from keyboard
     * Then search for it in "playlist.txt" if exists prints the name of song,
     * Then prints the song's artist and duration. 
     */
    public static void printDurationAndArtistBySong(){
        In keyboard = new In();
        StdOut.println("Enter Song name:");
        String inputSong = keyboard.readLine();
        In in = new In("./playlist.txt");
        boolean found = false;
        while (in.hasNextLine()) {
            String songDetails = in.readLine();
            int commaIndex = songDetails.indexOf(',');
            int secondCommaIndex = songDetails.lastIndexOf(',');
            String song = songDetails.substring(commaIndex + 2, secondCommaIndex); // Including space
            if (song.equals(inputSong)){
                StdOut.println(songDetails);
                found = true;
            }
        }
        if (!found) {
            StdOut.println("Song not found in playlist");
        }
    }

    /**
     * The following function prints all songs from "playlist.txt" which have 
     * a longer duration than 5 minutes
     */
    public static void printAllSongsOver5Minutes(){
        In in = new In("./playlist.txt");
        while (in.hasNextLine()) {
            String songDetails = in.readLine();
            int secondCommaIndex = songDetails.lastIndexOf(',');
            String duration = songDetails.substring(secondCommaIndex + 2); // Including space
            String minutes = duration.substring(0, duration.indexOf(':'));
            if (Integer.parseInt(minutes) >= 5) {
                StdOut.println(songDetails);
            }
        }
    }

     /**
     * The following function prints all songs from "playlist.txt" which have 
     * a longer duration than 2:30 minutes and shorter than 4 minutes 
     */
    public static void printAllSongsOver2AndHalfMinutesAndUnder4Minutes(){
        In in = new In("./playlist.txt");
        while (in.hasNextLine()) {
            String songDetails = in.readLine();
            int secondCommaIndex = songDetails.lastIndexOf(',');
            String duration = songDetails.substring(secondCommaIndex + 2); // Including space
            String minutes = duration.substring(0, duration.indexOf(':'));
            String seconds = duration.substring(duration.indexOf(':') + 1);
            if (Integer.parseInt(minutes) == 3 || (Integer.parseInt(minutes) == 2 && Integer.parseInt(seconds) >= 30)) {
                StdOut.println(songDetails);
            }
        }
    }

    /**
     * The following function prints all song details from "playlist.txt" which the Artist is 'Queen'
     * 
     * Yes it is the same solution as "Eminem", but I am betting that someone will use plain isSubstring check... 
     * Which here will fail (due to "Dancing Queen"). If no one didn't ask how can we include it 
     */
    public static void printAllQueenSongs(){
        In in = new In("./playlist.txt");
        while (in.hasNextLine()) {
            String songDetails = in.readLine();
            int commaIndex = songDetails.indexOf(',');
            String artist = songDetails.substring(0, commaIndex);
            if (artist.equals("Queen")){
                System.out.println(songDetails);
            }
        }
    }

    /**
     * The following function prints all song details from "playlist.txt" which the name of the song includes 'Black'
     * Yes it is the same solution as Before, but I am betting that someone will use plain isSubstring check... 
     * Which here will fail (due to "Black Eye Peas"). If no one didn't ask how can we include it
     */
    public static void printAllSongsOverWithBlackInName(){
        In in = new In("./playlist.txt");
        while (in.hasNextLine()) {
            String songDetails = in.readLine();
            int commaIndex = songDetails.indexOf(',');
            int secondCommaIndex = songDetails.lastIndexOf(',');
            String song = songDetails.substring(commaIndex + 2, secondCommaIndex); // Including space
            if (song.indexOf("Black") != -1){
                System.out.println(songDetails);
            }
        }
    }

    /**
     * The following function checks the which artist has the most songs in "playlist.txt"
     * For you: Coldplay has the most songs with 21 songs
     */
    public static void printTheArtistWithMostSongs(){
        int [] songCount = new int[200];
        String [] artists = new String[200];
        int numberOfArtists = 0;
        In in = new In("./playlist.txt");
        while (in.hasNextLine()) {
            String songDetails = in.readLine();
            int commaIndex = songDetails.indexOf(',');
            String artist = songDetails.substring(0, commaIndex);
            boolean found = false;
            for (int i = 0; i < numberOfArtists; i++) {
                if (artists[i].equals(artist)){
                    songCount[i]++;
                    found = true;
                    break;
                }
            }
            if (!found){
                artists[numberOfArtists] = artist;
                songCount[numberOfArtists] = 1;
                numberOfArtists++;
            }
        }
        int maxSongs = 0;
        int maxIndex = 0;
        for (int i = 0; i < numberOfArtists; i++) {
            if (songCount[i] > maxSongs){
                maxSongs = songCount[i];
                maxIndex = i;
            }
        }
        StdOut.println(artists[maxIndex] + " has the most songs with " + maxSongs + " songs");
    }
}
