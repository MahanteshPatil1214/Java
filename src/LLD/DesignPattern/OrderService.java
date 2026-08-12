package LLD.DesignPattern;

public class OrderService {
//    EmailNotification emailNotification = new EmailNotification();
//    SmsNotification smsNotification = new SmsNotification();
//
//    public void sendNotificationEmail(){
//        emailNotification.send();
//    }
//
//    public void sendSmsNotification(){
//        smsNotification.send();
//    }

    public void sendNotification(String type){
        Notification notification = NotificationFactory.sendNotification(type);
        notification.send();
    }
}
