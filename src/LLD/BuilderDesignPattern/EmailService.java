package LLD.BuilderDesignPattern;

public class EmailService {
    public void sendWelcomeEmail() {
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.setName("Mahantesh")
                .setEmail("mahanteshpatil642@gmail.com")
                .setAge(21);
        User user = new User(userBuilder);
        System.out.println("Welcome email sent to -> " + user);
    }
}

