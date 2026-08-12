package LLD.DesignPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeliveryService {
    public void sendNotification(List<String> types){
        List<Notification> notifications = NotificationFactory.sendNotification(types);
        for(Notification notification : notifications) {
            notification.send();
        }
    }
}
