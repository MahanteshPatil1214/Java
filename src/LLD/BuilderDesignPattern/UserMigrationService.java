package LLD.BuilderDesignPattern;

public class UserMigrationService {
    public void migrateUser(){
        User user = new User.UserBuilder()
                .setName("Rahul")
                .setAge(20)
                .setEmail("abc@123")
                .build();
        System.out.println("User migrated -> " + user) ;
    }
}
