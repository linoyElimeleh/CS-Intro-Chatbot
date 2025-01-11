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

    public Song(String title, int durationIsSeconds, String releaseYear, GenreEnum genre) {
        this.title = StringHelpers.captializeWords(title);
        this.durationIsSeconds = durationIsSeconds;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = 0;
        this.numberOfRatings = 0;
        this.totalOfRatings = 0;
        this.listens = 0;
        this.id = Song.idCalc();
    }

    private static int idCalc() {
        return idCalc++;
    }

    public int getId() {
        return this.id;
    }

    public int getListens() {
        return this.listens;
    }

    public int getDuration() {
        return this.durationIsSeconds;
    }

    public String getTitle() {
        return this.title;
    }

    public String gerReleaseYear() {
        return this.title;
    }

    public double getRating() {
        return this.rating;
    }

    public GenreEnum getGenreEnum() {
        return this.genre;
    }

    public String getGenre() {
        return this.genre.getName();
    }

    public int getNumberOfRatings() {
        return this.numberOfRatings;
    }

    public int getTotalRating() {
        return this.totalOfRatings;
    }

    public void updateCountOfListens() {
        this.listens++;
    }

    public void updateRating(int rating) {
        this.numberOfRatings++;
        this.totalOfRatings += rating;
        this.rating = (this.totalOfRatings + 0.0) / this.numberOfRatings;
    }
}