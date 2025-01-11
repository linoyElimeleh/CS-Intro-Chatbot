public class User {
    private static int idCalc = 0;
    private int id;
    private Song[] playlist;
    private int maxSongsSizeInPlaylist;
    private int songsInPlaylistCount;
    private String name;

    /*
     * Function to calculate the id a new User.
     * It uses the static idCalc field to keep track of the last id used.
     */
    private static int idCalc() {
        return idCalc++;
    }

    /*
     * Constructor with a specified number of songs in the user's playlist
     * 
     * Key points:
     * 1. The name should be capitalized
     * 2. The number of songs in the playlist should be greater than or equal to 0
     * 3. A new user has no songs in the playlist
     * 4. The id should be calculated automatically
     */
    public User(String name, int number) {
        // implement
    }

    /*
     * Function to find the index of a song in the playlist array
     * 
     * Key points:
     * 1. The title of the song is used to find the index
     * 2. If the song is not found, return -1
     */
    private int indexOf(Song s) {
        // implement
    }

    /*
     * Function to find the index of a song in the playlist array BY TITLE
     * 
     * Key points:
     * 1. The title of the song is used to find the index
     * 2. If the song is not found, return -1
     * 3. Rememmber that the title of songs are capitalized
     */
    private int indexOf(String title) {
        // implement
    }

    /*
     * Function to resize the playlist array
     * 
     * Key points:
     * 1. After the execution of this function, the array should be twice the size
     * of the old array
     * 2. The old songs in the playlist should be copied to the new array
     * 3. Pay attention to the fields that need to be updated
     */
    private void resize() {
        // implement
    }

    /*
     * Function to add a song to the playlist array
     * 
     * Key points:
     * 1. If the song is already in the array, do not add it again
     * 2. If the array is full, resize it
     */
    public void addSong(Song s) {
        // implement
    }

    /*
     * Function to play a song in the playlist by a given name
     * 
     * Key points:
     * 1. If the song is not in the playlist, throw the appropriate exception
     * 2. Update the count of listens of the song
     */
    public void playSong(String name) {
        // implement
    }

    /*
     * Function to rate a song in the playlist
     * 
     * Key points:
     * 1. If the rating is not between 0 and 5, throw the appropriate exception
     * 2. If the song is not in the playlist, throw the appropriate exception
     * 3. Update the rating of the song
     */
    public void rateSong(String songName, int rating) {
        // implement
    }
}
