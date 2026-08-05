package LLD.bookMyShow;

import java.util.List;

public class Booking {
    private final String bookingId;
    private final Show show;
    private final List<ShowSeat> bookedSeats;
    private final String userId;
    private final double amount;
    private boolean isConfirmed;

    public Booking(String bookingId, Show show, List<ShowSeat> bookedSeats, String userId, double amount) {
        this.bookingId = bookingId;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.userId = userId;
        this.amount = amount;
        this.isConfirmed = false;
    }

    public String getBookingId() { return bookingId; }
    public double getAmount() { return amount; }
    public String getUserId() { return userId; }
    public List<ShowSeat> getBookedSeats() { return bookedSeats; }
    public void setConfirmed(boolean confirmed) { isConfirmed = confirmed; }
}
