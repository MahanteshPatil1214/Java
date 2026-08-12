package LLD.DesignPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeliveryService {
    public void sendNotification(List<String> types){
        NotificationFactory factory = new SmsFactory();
        Notification notification = factory.createNotification();
        Template template = factory.createTemplate();
        notification.send();
        template.format();
    }
}
