package LLD.DesignPattern;

public class OrderService {

    public void sendNotification(String type){
        NotificationFactory factory = new EmailFactory();
        Notification notification = factory.createNotification();
        Template template = factory.createTemplate();
        notification.send();
        template.format();
    }
}
