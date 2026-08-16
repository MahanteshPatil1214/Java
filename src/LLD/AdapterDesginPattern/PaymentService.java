package LLD.AdapterDesginPattern;

public class PaymentService {

    PaypalGateway paypalGateway = new PaypalGateway();
    RazorPayGateway razorPayGateway = new RazorPayGateway();
    public String pay(int amount,int customerId){
       int result = paypalGateway.doTransaction(Double.valueOf(amount),customerId);
       if(result==1) {
           return "Success";
       }
       else {
           return "Not Success";
       }
    }
}
