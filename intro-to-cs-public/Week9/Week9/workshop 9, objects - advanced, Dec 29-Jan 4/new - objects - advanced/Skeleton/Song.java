public class Song {
    private static int idCalc = 0;
    private int id;
    private String title;
    private int durationIsSeconds;
    private double rating;
    private int numberOfRatings;
    private int totalOfRatings;
    private String releaseYear;
    private int listens;
    private GenreEnum genre;

    /*
     * Constructor
     * 
     * Key points:
     * 1. The title should be capitalized
     * 2. New songs have no ratings
     * 3. New songs have no listens
     * 4. The id should be calculated automatically
     */
    public Song(String title, int durationIsSeconds, String releaseYear, GenreEnum genre) {

    }

    /*
     * Function to calculate the id a new song.
     * It uses the static idCalc field to keep track of the last id used.
     */
    private static int idCalc() {
        return idCalc++;
    }

    // ⬇︎ Getters ⬇︎
    public int getId() {
        // implement
    }

    public int getListens() {
        // implement
    }

    public int getDuration() {
        // implement
    }

    public String getTitle() {
        // implement
    }

    public String gerReleaseYear() {
        // implement
    }

    public double getRating() {
        // implement
    }

    public GenreEnum getGenreEnum() {
        // implement
    }

    public String getGenre() {
        // implement
    }

    public int getNumberOfRatings() {
        // implement
    }

    public int getTotalRating() {
        // implement
    }
    // ⬆︎ Getters ⬆︎

    /*
     * Function to update (increase by one) the number of listens
     */
    public void updateCountOfListens() {
        // implement
    }

    /*
     * Function to update the rating of the song
     * 
     * Key points:
     * 1. We need to keep track of the number of ratings and the total of ratings
     * 2. The rating is the total of ratings divided by the number of ratings (be
     * aware of the types)
     */
    public void updateRating(int rating) {
        // implement
    }
}