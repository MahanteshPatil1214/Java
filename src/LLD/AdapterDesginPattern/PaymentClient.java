package LLD.AdapterDesginPattern;

public class PaymentClient {
    PaymentService paymentService ;

    public PaymentClient(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void makePayment(){
        String result = paymentService.pay(100,123);
        if(result.equals("Success")){
            System.out.println("Payment done Successfully");
        }else {
            System.out.println("Payment Failed");
        }
    }
}
