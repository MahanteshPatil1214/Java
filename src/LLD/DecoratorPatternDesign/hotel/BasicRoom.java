package LLD.DecoratorPatternDesign.hotel;

public class BasicRoom implements Room{
    @Override
    public String getDescription() {
        return "Basic Hotel room";
    }

    @Override
    public int getCost() {
        return 3000;
    }
}
