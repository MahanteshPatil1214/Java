package Problems;

public class WordsInString {
    public static void main(String[] args) {
        String str = "java is a programming language";
        String[] words = str.trim().split("\s+");
        System.out.println(words.length);
    }

}
