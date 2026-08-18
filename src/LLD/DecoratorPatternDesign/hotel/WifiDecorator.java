package LLD.DecoratorPatternDesign.hotel;

public class WifiDecorator extends RoomDecorator{
    public WifiDecorator(Room room) {
        super(room);
    }

    @Override
    public String getDescription() {
        return room.getDescription() + " with Wifi";
    }

    @Override
    public int getCost() {
        return room.getCost()+200;
    }
}
