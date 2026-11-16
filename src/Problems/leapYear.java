package Problems;

public class leapYear {
    public static void main(String[] args) {
        int year = 2027;
        boolean isLeapYear = false;
        if((year % 4 ==0 && year%100 !=0) || year%400 ==0){
            isLeapYear=true;
        }
        System.out.println(isLeapYear);
    }
}
