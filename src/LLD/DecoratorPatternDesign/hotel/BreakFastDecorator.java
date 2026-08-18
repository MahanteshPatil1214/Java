package LLD.DecoratorPatternDesign.hotel;

public class BreakFastDecorator extends RoomDecorator{
    public BreakFastDecorator(Room room) {
        super(room);
    }

    @Override
    public String getDescription() {
        return room.getDescription() + " with BreakFast";
    }

    @Override
    public int getCost() {
        return room.getCost() + 200;
    }
}
