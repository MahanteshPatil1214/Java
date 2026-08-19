package LLD.ProxyDesignPattern.ProtectionProxy;

public class Main {
    public static void main(String[] args) {
        Database db = new DatabaseProxy("VIEWER");
        db.delete();
    }
}
