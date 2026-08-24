package advanced.lesson11;
import java.util.ArrayList;

public class StreamAPI {
    public static void main(String[] args) {
        
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);

        numbers.stream()
               .filter(n -> n % 2 == 0) // filter(condition)
               .map(n -> n * 2) // map(transformation)
               .forEach(n -> System.out.println(n));
               System.out.println(numbers);
    }
}
