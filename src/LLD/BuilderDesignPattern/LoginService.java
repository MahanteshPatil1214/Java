package LLD.BuilderDesignPattern;

public class LoginService {
    void registerUser(String name,int age,String email) {
    User user = new User(name,age,email);
    System.out.println("User Registered Successfully -> " + user);
    }
}
