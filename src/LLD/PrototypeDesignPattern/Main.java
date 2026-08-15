package LLD.PrototypeDesignPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        long startTime = System.currentTimeMillis();
        GameBotCharacters gbc1 = new GameBotCharacters("Bot1", 100, 0,new ArrayList<>(Arrays.asList("Gun")));
//      object cloning
        GameBotCharacters gbc2 = gbc1.customizedClone();
        gbc2.setName("Bot2");
        gbc2.setHealth(100);
        gbc2.setAttackPower(20);
        List<String> weapons = gbc2.getWeapons();
        weapons.add("Rifle");
        long endTime = System.currentTimeMillis();
        System.out.println(gbc1);
        System.out.println(gbc2);
        System.out.println("Total time taken: " + (endTime-startTime));
    }
}
