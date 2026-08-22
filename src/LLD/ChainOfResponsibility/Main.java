package LLD.ChainOfResponsibility;

public class Main {


    public static void main(String[] args) {
        Client client = new Client(new Chatbot(new CustomExecutive(new TechTeam())));
        client.raiseIssue(new Issue("LEVEL2" ,"INITIATED"));

    }
}
