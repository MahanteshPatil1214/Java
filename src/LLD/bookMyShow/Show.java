package LLD.bookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private final String showId;
    private final Movie movie;
    private final List<ShowSeat> showSeats;

    public Show(String showId, Movie movie, List<Seat> physicalSeats) {
        this.showId = showId;
        this.movie = movie;
        this.showSeats = new ArrayList<>();
        for (Seat seat : physicalSeats) {
            this.showSeats.add(new ShowSeat(seat));
        }
    }

    public ShowSeat getShowSeat(String seatId) {
        return showSeats.stream()
                .filter(s -> s.getSeat().getSeatId().equals(seatId))
                .findFirst()
                .orElse(null);
    }

    public List<ShowSeat> getShowSeats() { return showSeats; }
    public Movie getMovie() { return movie; }
    public String getShowId() { return showId; }
}
