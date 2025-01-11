public enum GenreEnum {
    ROCK("Rock"),
    CLASSIC("Classic"),
    BLUES("Blues"),
    POP("Pop"),
    RAP("Rap"),
    HIP_HOP("Hip hop");

    final String name;

    GenreEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
