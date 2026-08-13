package LLD.BuilderDesignPattern;

public class UserMigrationService {
    public void migrateUser(){
        UserBuilder builder = new UserBuilder();
        builder.setName("Rahul")
                .setAge(20)
                .setEmail("abc@123");

        User user = new User(builder);
        System.out.println("User migrated -> " + user) ;
    }
}
