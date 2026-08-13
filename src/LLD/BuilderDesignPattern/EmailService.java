package LLD.BuilderDesignPattern;

public class EmailService {
    public void sendWelcomeEmail() {
        User user = new User("Mahantesh", 21, "patilmahantesh642@gmail.com");
        System.out.println("Welcome email sent to -> " + user);
    }
}

