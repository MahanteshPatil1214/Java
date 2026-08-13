package LLD.BuilderDesignPattern;

public class LoginService {
    void registerUser(String name,int age,String email,String city) {
    User user = new User.UserBuilder()
            .setEmail(email)
            .setAge(age)
            .setName(name)
            .setCity(city)
            .build();
    System.out.println("User Registered Successfully -> " + user);
    }
}
