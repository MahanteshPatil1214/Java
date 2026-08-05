package LLD.bookMyShow;

public class UpiPaymentStrategy implements PaymentStrategy {
    private final String upiId;

    public UpiPaymentStrategy(String upiId) { this.upiId = upiId; }

    @Override
    public boolean processPayment(String bookingId, double amount) {
        System.out.println("[PAYMENT] Processing UPI payment of $" + amount + " for Booking: " + bookingId + " via UPI: " + upiId);
        return true; // Simulated success
    }
}
