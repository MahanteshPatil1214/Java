package Problems;

public class StringPalindrome {
    public static void main(String[] args) {
        String str = "mam";
//        String rev = "";
//        for (int i = str.length()-1; i >=0 ; i--) {
//            rev += str.charAt(i);
//        }
//        boolean isPalindrome = (str.equals(rev)) ? true : false;
//        System.out.println(isPalindrome);
        int l = 0;int r=str.length()-1;
        boolean isPlaindrome = false;
        while (l<=r){
            if(str.charAt(l) == str.charAt(r)) {
                isPlaindrome = true;
                l++;
                r--;
            }else {
                isPlaindrome=false;
            }

        }
        System.out.println(isPlaindrome);
    }
}
