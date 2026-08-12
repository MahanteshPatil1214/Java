package LLD.DesignPattern;

public class SmsTemplate implements Template{
    @Override
    public void format() {
        System.out.println("Formating SMS ");
    }
}
