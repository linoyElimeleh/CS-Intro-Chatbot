public class Singer {
    private static int idCalc = 0;
    private int id;
    private String name;
    private Song[] songs;
    private int maxSongsSize; // a field to keep track of the maximum number of songs that can be stored
    private int songCount;

    /*
     * Constructor
     * 
     * Key points:
     * 1. The name should be capitalized
     * 2. Assume an initial length of 10 songs
     * 3. A new singer has no songs
     * 4. The id should be calculated automatically
     */
    public Singer(String name) {
        // implement
    }

    /*
     * Function to calculate the id a new Singer.
     * It uses the static idCalc field to keep track of the last id used.
     */
    private static int idCalc() {
        return idCalc++;
    }

    /*
     * Constructor with a specified number of songs
     * 
     * Key points:
     * 1. The name should be capitalized
     * 2. The number of songs should be greater than or equal to 0
     * 3. A new singer has no songs
     * 4. The id should be calculated automatically
     */
    public Singer(String name, int number) {
        // implement
    }

    /*
     * Function to find the index of a song in the songs array
     * 
     * Key points:
     * 1. The title of the song is used to find the index
     * 2. If the song is not found, return -1
     */
    private int indexOf(Song s) {
        // implement
    }

    /*
     * Function to resize the songs array
     * 
     * Key points:
     * 1. After the execution of this function, the array should be twice the size
     * of the old array
     * 2. The old songs should be copied to the new array
     * 3. Pay attention to the fields that need to be updated
     */
    private void resize() {
        // implement
    }

    /*
     * Function to add a song to the songs array
     * 
     * Key points:
     * 1. If the song is already in the array, do not add it again
     * 2. If the array is full, resize it
     */
    public void addSong(Song s) {
        // implement
    }

    /*
     * Constructor with a single song
     */
    public Singer(String name, Song song) {
        this(name);
        this.addSong(song);
    }

    /*
     * Function to return the sum of the number of listens for all songs
     */
    public int getCountListens() {
        // implement
    }

    /*
     * Function to return the average rating of all songs
     */
    public double getAverageRating() {
        // implement
    }

    /*
     * Function to return the number of songs in a specific genre
     */
    public int getNumSongsInGenre(GenreEnum genre) {
        // implement
    }

    /*
     * Function to swap two songs in a songs array
     */
    private void swap(Song[] newSongs, int i, int j) {
        // implement
    }

    /*
     * Function to return the top rated songs
     * 
     * Key points:
     * 1. The songs should be sorted by rating in descending order
     * 2. If two songs have the same rating, the order does not matter
     * 3. The songs array should not be modified
     * 
     */
    public Song[] topRatedSongs() {

        /*
         * Implementation guidance:
         * 1. Create a new array of songs with the same length as the songs array
         * 2. Copy the songs array to the new array
         * 3. Go through the new array, comparing the ratings of each song with the
         * ratings of the songs that come after it. If the rating of the current song is
         * less than the rating of the song that comes after it, swap the two songs.
         */

        // implement
    }
}