package advanced.lesson11;
import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        
        HashSet<String> names = new HashSet<>();

        names.add("Anas"); // add hua → {Anas}
        names.add("Rahul"); // add hua → {Anas, Rahul}
        names.add("Anas"); // DUPLICATE — silently ignore, kuch nahi hota

        System.out.println(names);
    }
    
}
