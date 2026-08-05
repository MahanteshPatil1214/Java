package LLD.bookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingService {
    private static final int LOCK_DURATION_SECONDS = 3; // Kept short (3s) for easy testing!
    private final Map<String, Booking> bookings = new ConcurrentHashMap<>();
    private final AtomicInteger bookingCounter = new AtomicInteger(5000);

    // Multi-Seat Atomic Lock Attempt
    public Booking createBooking(String userId, Show show, List<String> seatIds) {
        List<ShowSeat> seatsToLock = new ArrayList<>();
        for (String seatId : seatIds) {
            ShowSeat seat = show.getShowSeat(seatId);
            if (seat == null) throw new IllegalArgumentException("Seat not found: " + seatId);
            seatsToLock.add(seat);
        }

        // Lock seats sequentially
        List<ShowSeat> lockedSeats = new ArrayList<>();
        for (ShowSeat showSeat : seatsToLock) {
            if (showSeat.lockSeat(userId, LOCK_DURATION_SECONDS)) {
                lockedSeats.add(showSeat);
            } else {
                // If ANY seat fails to lock, rollback all previously acquired locks in this transaction!
                System.out.println("[LOCK FAILED] " + userId + " failed to acquire seat " + showSeat.getSeat().getSeatId() + ". Rolling back!");
                for (ShowSeat rollbackSeat : lockedSeats) {
                    rollbackSeat.releaseLock();
                }
                return null;
            }
        }

        double totalAmount = calculatePrice(lockedSeats);
        String bookingId = "BKG-" + bookingCounter.getAndIncrement();
        Booking booking = new Booking(bookingId, show, lockedSeats, userId, totalAmount);
        bookings.put(bookingId, booking);

        System.out.println("[LOCK SUCCESS] Seats " + seatIds + " locked for user " + userId + ". Booking ID: " + bookingId);
        return booking;
    }

    public boolean confirmCheckout(String bookingId, PaymentStrategy paymentStrategy) {
        Booking booking = bookings.get(bookingId);
        if (booking == null) return false;

        boolean paymentSuccess = paymentStrategy.processPayment(bookingId, booking.getAmount());
        if (paymentSuccess) {
            // Confirm seat status
            for (ShowSeat seat : booking.getBookedSeats()) {
                if (!seat.confirmBooking(booking.getUserId())) {
                    System.out.println("[CONFIRMATION FAILED] Lock expired before checkout completed for user " + booking.getUserId());
                    return false;
                }
            }
            booking.setConfirmed(true);
            System.out.println("[BOOKING SUCCESS] Booking " + bookingId + " confirmed for user " + booking.getUserId());
            return true;
        } else {
            // Release seats on failed payment
            for (ShowSeat seat : booking.getBookedSeats()) {
                seat.releaseLock();
            }
            return false;
        }
    }

    private double calculatePrice(List<ShowSeat> seats) {
        double price = 0;
        for (ShowSeat seat : seats) {
            price += (seat.getSeat().getSeatType() == SeatType.PREMIUM) ? 300 : 150;
        }
        return price;
    }
}
