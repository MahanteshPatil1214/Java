package Problems;

public class CountVowelsAndConsonants {
    public static void main(String[] args) {
        String str = "java programming";
        int v = 0, c = 0;
        str=str.toLowerCase();
        for (char ch : str.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) v++;
            else if (Character.isLetter(ch)) {
                c++;
            }
        }
        System.out.println("v:" + v + " c:" + c);
    }
}
