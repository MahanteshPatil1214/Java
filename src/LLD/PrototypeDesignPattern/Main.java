package LLD.PrototypeDesignPattern;

public class Main {
    public static void main(String[] args) {


        long startTime = System.currentTimeMillis();
        GameBotCharacters gbc1 = new GameBotCharacters("Bot1", 100, 0);
        GameBotCharacters gbc2 = new GameBotCharacters("Bot2", 200, 10);
        GameBotCharacters gbc3 = new GameBotCharacters("Bot3", 400, 15);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime-startTime));
    }
}
