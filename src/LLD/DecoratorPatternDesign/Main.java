package LLD.DecoratorPatternDesign;

public class Main {
    public static void main(String[] args) {
        Pizza pizza=new MargheritaPizza();

        System.out.println("Description :" + pizza.getDescription() + "\t\t Cost :" + pizza.getCost());

        pizza = new CheeseDecorator(pizza);

        System.out.println("Description :" + pizza.getDescription() + "\t\t Cost :" + pizza.getCost());

        pizza = new MushroomDecorator(pizza);
        System.out.println("Description :" + pizza.getDescription() + "\t\t Cost :" + pizza.getCost());
    }

}
