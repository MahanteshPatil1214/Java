package Problems;

public class StringPalindrome {
    public static void main(String[] args) {
        String str = "mam";
        String rev = "";
        for (int i = str.length()-1; i >=0 ; i--) {
            rev += str.charAt(i);
        }
        boolean isPalindrome = (str.equals(rev)) ? true : false;
        System.out.println(isPalindrome);
    }
}
