package LLD.DesignPattern;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();
        deliveryService.sendNotification(Arrays.asList("EMAIL"));

        OrderService orderService = new OrderService();
        orderService.sendNotification("SMS");

    }
}
