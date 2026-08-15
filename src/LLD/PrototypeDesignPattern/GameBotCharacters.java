package LLD.PrototypeDesignPattern;

public class GameBotCharacters {

    private String name;
    private int health;
    private int attackPower;

    @Override
    public String toString() {
        return "GameBotCharacters{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attackPower=" + attackPower +
                '}';
    }

    public GameBotCharacters(String name, int health, int attackPower){
//        Expensive operations
        System.out.println("Loading character animations from DB..");
        System.out.println("Loading sound effects from DB..");
        System.out.println("Preparing Ai battle Settings File...");

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Error in Thread");
        }

        this.name=name;
        this.health=health;
        this.attackPower=attackPower;



    }
}
