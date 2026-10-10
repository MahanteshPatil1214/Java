package Problems;

import java.util.HashSet;

public class FindFirstRepeatingCharacter {

    public static void main(String[] args) {
        String a = "aabccddfe";
        String result = repaeatingChar(a);
        System.out.println(result);
    }

    private static String repaeatingChar(String a) {
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if(seen.contains(ch))
                return String.valueOf(ch);
            else
                seen.add(ch);
        }
        return null;
    }
}
