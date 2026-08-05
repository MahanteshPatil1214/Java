package LLD.bookMyShow;

public class Movie {
    private final String movieId;
    private final String title;
    private final int durationInMinutes;

    public Movie(String movieId, String title, int durationInMinutes) {
        this.movieId = movieId;
        this.title = title;
        this.durationInMinutes = durationInMinutes;
    }

    public String getTitle() { return title; }
}
