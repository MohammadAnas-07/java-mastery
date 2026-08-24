package advanced.lesson11;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {

        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        numbers.add(1,99);

        System.out.println(numbers);
        
    }
    
}
