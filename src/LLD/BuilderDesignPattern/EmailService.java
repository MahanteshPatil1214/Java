package LLD.BuilderDesignPattern;

public class EmailService {
    public void sendWelcomeEmail() {
        User user = new User.UserBuilder()
                .setName("Mahantesh")
                .setEmail("mahanteshpatil642@gmail.com")
                .setAge(21)
                .build();
        System.out.println("Welcome email sent to -> " + user);
    }
}

