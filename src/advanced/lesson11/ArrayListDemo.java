package advanced.lesson11;
import java.util.ArrayList;

public class ArrayListDemo{
    public static void main(String[] args){

        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");

        System.out.println(fruits);              // poori list print
        System.out.println(fruits.size());        // kitne elements hain
        System.out.println(fruits.get(1));         // index 1 pe kya hai
        fruits.remove("Banana");                    // value se remove
        fruits.remove(0);                            // index se remove
        System.out.println(fruits.contains("Mango")); // hai ya nahi check



        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println(numbers); // [10,20,30]

        numbers.remove(1);
        System.out.println(numbers); // [10,20]

    }


}