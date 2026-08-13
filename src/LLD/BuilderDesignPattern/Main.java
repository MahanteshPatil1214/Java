package LLD.BuilderDesignPattern;

public class Main {
    public static void main(String[] args) {
        new EmailService().sendWelcomeEmail();
        new UserMigrationService().migrateUser();
        new LoginService().registerUser("Sam",21,"sam@123");
    }
}
