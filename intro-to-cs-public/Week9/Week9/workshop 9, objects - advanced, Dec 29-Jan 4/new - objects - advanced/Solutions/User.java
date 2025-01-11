public class User {
    private static int idCalc = 0;
    private int id;
    private Song[] playlist;
    private int maxSize;
    private int count;
    private String name;

    private static int idCalc() {
        return idCalc++;
    }

    public User(String name, int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        this.name = StringHelpers.captializeWords(name);
        this.playlist = new Song[number];
        this.count = 0;
        this.maxSize = number;
        this.id = User.idCalc();
    }

    private int indexOf(Song s) {
        for (int i = 0; i < this.playlist.length; i++) {
            if (this.playlist[i].getTitle().equals(s.getTitle())) {
                return i;
            }
        }
        return -1;
    }

    private int indexOf(String title) {
        for (int i = 0; i < this.playlist.length; i++) {
            if (this.playlist[i].getTitle().equals(StringHelpers.captializeWords(title))) {
                return i;
            }
        }
        return -1;
    }

    private void resize() {
        Song[] newSongs = new Song[this.maxSize * 2];
        for (int i = 0; i < this.maxSize; i++) {
            newSongs[i] = this.playlist[i];
        }
        this.maxSize = newSongs.length;
        this.playlist = newSongs;
    }

    public void addSong(Song s) {
        if (this.indexOf(s) != -1) {
            return;
        }
        if (this.count == this.maxSize) {
            this.resize();
        }
        this.playlist[this.count++] = s;
    }

    public void playSong(String name) {
        int index = this.indexOf(name);
        if (index == -1) {
            throw new IllegalArgumentException("Song not in playlist");
        }
        this.playlist[index].updateCountOfListens();
    }

    public void rateSong(String songName, int rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Invalid rating");
        }
        int index = this.indexOf(songName);
        if (index == -1) {
            throw new IllegalArgumentException("Song not in playlist");
        }
        this.playlist[index].updateCountOfListens();
    }
}
