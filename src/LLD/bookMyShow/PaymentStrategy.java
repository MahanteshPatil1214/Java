package LLD.bookMyShow;

public interface PaymentStrategy {
    boolean processPayment(String bookingId, double amount);
}
