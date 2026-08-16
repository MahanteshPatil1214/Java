package LLD.AdapterDesginPattern;

public class Main {
    public static void main(String[] args) {
      PaymentClient paymentClient = new PaymentClient(new RazorPayAdapter(new RazorPayGateway()));
      paymentClient.makePayment();
    }
}
