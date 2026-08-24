package advanced.lesson11;
import java.util.HashSet;

public class RemoveDuplicateCharHashSet {
    public static void main(String[] args) {
        String str = "hello";
        HashSet<Character> uniqueChars = new HashSet<>();

        for(int i = 0; i < str.length(); i++){
            uniqueChars.add(str.charAt(i));
        }

        System.out.println(uniqueChars);
        System.out.println("Unique count: " + uniqueChars.size());
    }
}
