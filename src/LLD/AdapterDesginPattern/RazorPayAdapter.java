package LLD.AdapterDesginPattern;

public class RazorPayAdapter implements PaymentService{

    RazorPayGateway razorPayGateway;

    public RazorPayAdapter(RazorPayGateway razorPayGateway) {
        this.razorPayGateway = razorPayGateway;
    }

    @Override
    public String pay(int amount, int customerId) {
        boolean isSuccess =razorPayGateway.performTransaction(100.00,1245);
        if(isSuccess){
            return "Success";
        }
        return "Failed";
    }
}
