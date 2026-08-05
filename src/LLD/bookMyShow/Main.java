package LLD.bookMyShow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 1. Setup Seats & Movie
        List<Seat> physicalSeats = List.of(
                new Seat("A1", 1, 1, SeatType.REGULAR),
                new Seat("A2", 1, 2, SeatType.REGULAR),
                new Seat("A3", 1, 3, SeatType.PREMIUM)
        );

        Movie movie = new Movie("M1", "Interstellar", 169);
        Show show = new Show("S101", movie, physicalSeats);
        BookingService bookingService = new BookingService();

        System.out.println("=== TEST 1: CONCURRENT BOOKING FOR SEAT A1 ===");
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // User 1 (Alice) and User 2 (Bob) both attempt to lock Seat A1 at the exact same time
        Runnable aliceTask = () -> {
            Booking booking = bookingService.createBooking("Alice", show, List.of("A1"));
            if (booking != null) {
                bookingService.confirmCheckout(booking.getBookingId(), new UpiPaymentStrategy("alice@upi"));
            }
        };

        Runnable bobTask = () -> {
            Booking booking = bookingService.createBooking("Bob", show, List.of("A1"));
            if (booking != null) {
                bookingService.confirmCheckout(booking.getBookingId(), new UpiPaymentStrategy("bob@upi"));
            }
        };

        executor.execute(aliceTask);
        executor.execute(bobTask);

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("\n=== TEST 2: LOCK TIMEOUT & AUTO-RELEASE ===");
        // Charlie locks seat A2 but does NOT pay within TTL (3 seconds)
        Booking charlieBooking = bookingService.createBooking("Charlie", show, List.of("A2"));
        System.out.println("Seat A2 status immediately after Charlie locks: " + show.getShowSeat("A2").getStatus());

        System.out.println("Waiting 4 seconds for lock to expire...");
        Thread.sleep(4000);

        System.out.println("Seat A2 status after 4 seconds: " + show.getShowSeat("A2").getStatus());

        // Dave tries to book A2 now that Charlie's lock expired
        System.out.println("\nDave attempting to book A2 now...");
        Booking daveBooking = bookingService.createBooking("Dave", show, List.of("A2"));
        if (daveBooking != null) {
            bookingService.confirmCheckout(daveBooking.getBookingId(), new UpiPaymentStrategy("dave@upi"));
        }
    }
}
