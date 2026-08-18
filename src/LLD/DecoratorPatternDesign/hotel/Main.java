package LLD.DecoratorPatternDesign.hotel;

public class Main {
    public static void main(String[] args) {
        Room room = new BasicRoom();
        System.out.println("Description : " + room.getDescription());
        System.out.println("Cost :" + room.getCost());
        room = new BreakFastDecorator(room);
        System.out.println("Description : " + room.getDescription());
        System.out.println("Cost :" + room.getCost());
        room = new WifiDecorator(room);
        System.out.println("Description : " + room.getDescription());
        System.out.println("Cost :" + room.getCost());
    }


}
