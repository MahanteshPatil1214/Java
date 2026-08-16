package LLD.AdapterDesginPattern;

public class PayPalAdapter implements PaymentService{
    PaypalGateway paypalGateway;

    public PayPalAdapter(PaypalGateway paypalGateway) {
        this.paypalGateway = paypalGateway;
    }

    @Override
    public String pay(int amount, int customerId) {
        int result = paypalGateway.doTransaction(100.00, 123);
        if (result == 1) {
            return "Success";
        }
        return "Invalid";
    }
}
