package LLD.AdapterDesginPattern;

public class PaymentClient {
    PaymentService paymentService = new PaymentService();

    public void makePayment(){
        String result = paymentService.pay(100,123);
        if(result.equals("Success")){
            System.out.println("Payment done Successfully");
        }else {
            System.out.println("Payment Failed");
        }
    }
}
