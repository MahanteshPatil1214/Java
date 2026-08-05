package LLD.bookMyShow;

public class Seat {
    private final String seatId;
    private final int row;
    private final int column;
    private final SeatType seatType;

    public Seat(String seatId, int row, int column, SeatType seatType) {
        this.seatId = seatId;
        this.row = row;
        this.column = column;
        this.seatType = seatType;
    }

    public String getSeatId() {
        return seatId;
    }

    public SeatType getSeatType() {
        return seatType;
    }
}
