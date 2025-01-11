public class Singer {
    private static int idCalc = 0;
    private int id;
    private String name;
    private Song[] songs;
    private int maxSize;
    private int count;

    public Singer(String name) {
        this.name = StringHelpers.captializeWords(name);
        this.songs = new Song[10]; // Default number
        this.count = 0;
        this.maxSize = 10;
        this.id = Singer.idCalc();
    }

    private static int idCalc() {
        return idCalc++;
    }

    public Singer(String name, int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        this.name = StringHelpers.captializeWords(name);
        this.songs = new Song[number];
        this.count = 0;
        this.maxSize = number;
        this.id = Singer.idCalc();
    }

    private int indexOf(Song s) {
        for (int i = 0; i < this.songs.length; i++) {
            if (this.songs[i].getTitle().equals(s.getTitle())) {
                return i;
            }
        }
        return -1;
    }

    private void resize() {
        Song[] newSongs = new Song[this.maxSize * 2];
        for (int i = 0; i < this.maxSize; i++) {
            newSongs[i] = this.songs[i];
        }
        this.maxSize = newSongs.length;
        this.songs = newSongs;
    }

    public void addSong(Song s) {
        if (this.indexOf(s) != -1) {
            return;
        }
        if (this.count == this.maxSize) {
            this.resize();
        }
        this.songs[this.count++] = s;
    }

    public Singer(String name, Song song) {
        this(name);
        this.addSong(song);
    }

    public int getCountListens() {
        int numOfListens = 0;
        for (int i = 0; i < this.songs.length; i++) {
            numOfListens = this.songs[i].getListens();
        }
        return numOfListens;
    }

    public double getAverageRating() {
        int totalRatings = 0;
        int numRatings = 0;
        for (int i = 0; i < this.songs.length; i++) {
            if (this.songs[i].getNumberOfRatings() != 0) {
                totalRatings += this.songs[i].getTotalRating();
                numRatings += this.songs[i].getNumberOfRatings();
            }
        }
        return (totalRatings + 0.0) / numRatings;
    }

    public int getNumSongsInGenre(GenreEnum genre) {
        int count = 0;
        for (int i = 0; i < this.songs.length; i++) {
            if (this.songs[i].getGenreEnum().equals(genre)) {
                count++;
            }
        }
        return count;
    }

    private void swap(Song[] newSongs, int i, int j) {
        Song s = newSongs[i];
        newSongs[i] = newSongs[j];
        newSongs[j] = s;
    }

    public Song[] topRatedSongs() {
        Song[] sortedSongs = new Song[this.count];
        for (int i = 0; i < this.songs.length; i++) {
            sortedSongs[i] = this.songs[i];
        }
        for (int i = 0; i < sortedSongs.length; i++) {
            for (int j = i + 1; j < sortedSongs.length; j++) {
                if (this.songs[i].getRating() < this.songs[j].getRating()) {
                    swap(sortedSongs, i, j);
                }
            }
        }
        return sortedSongs;
    }
}