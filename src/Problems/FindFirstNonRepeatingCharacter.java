package Problems;

import java.util.HashMap;

public class FindFirstNonRepeatingCharacter {

     public static String nonRepeatingChar(String s){
         HashMap<Character,Integer> seen = new HashMap<>();
         for (int i = 0; i < s.length(); i++) {
             char ch = s.charAt(i);
             seen.put(ch,seen.getOrDefault(ch,0)+1);
         }
         for (int i = 0; i < s.length(); i++) {
             ;char ch=s.charAt(i);
             if(seen.get(ch) == 1) return String.valueOf(ch);
         }
         return " ";
     }

    public static void main(String[] args) {
        String name = "aabccdeefrr";
        String result = nonRepeatingChar(name);
        System.out.println(result);
    }
}
