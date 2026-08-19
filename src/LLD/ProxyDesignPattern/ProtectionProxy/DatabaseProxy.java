package LLD.ProxyDesignPattern.ProtectionProxy;

public class DatabaseProxy implements Database{
    private Database db;
    private String role;

    public DatabaseProxy(String role){
        this.role=role;
        this.db = new MySqlDatabase();
    }
    @Override
    public void delete() {
        if(role.equals("ADMIN")) {
            db.delete();
        }else{
            System.out.println("Access Has denied");
        }
    }
}
