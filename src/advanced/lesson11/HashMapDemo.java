package advanced.lesson11;
import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        
        HashMap<String, Integer> ages = new HashMap<>();

        ages.put("Anas",22);
        ages.put("Anas",30);
        ages.put("Rahul",25);

        System.out.println(ages.get("Anas")); //30
        System.out.println(ages); // {Anas=30, Rahul=25}

        if(ages.containsKey("Anas")){
            System.out.println("Anas ki age hai: " + ages.get("Anas"));
        }else{
            System.out.println("Anas ka data nahi hai");
        }

        
    }

}
