package LLD.BuilderDesignPattern;

public class LoginService {
    void registerUser(String name,int age,String email,String city) {
        UserBuilder builder = new UserBuilder();
        builder.setEmail(email)
                .setAge(age)
                .setName(name)
                .setCity(city);
    User user = new User(builder);
    System.out.println("User Registered Successfully -> " + user);
    }
}
