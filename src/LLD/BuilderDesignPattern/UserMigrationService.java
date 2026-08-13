package LLD.BuilderDesignPattern;

public class UserMigrationService {
    public void migrateUser(){
        User user = new User("Rahul",30,"rahul@123.com");
        System.out.println("User migrated -> " + user) ;
    }
}
