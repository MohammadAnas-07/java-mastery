package fundamentals.lesson02;

public class TypeCastingDemo {

    public static void main(String[] args) {

        // Implicit Casting
        int age = 25;
        double d = age;
        System.out.println("Implicit Casting: " + d);

        // Explicit Casting Example 1
        double pi = 3.14;
        int x = (int) pi;
        System.out.println("Explicit Casting 1: " + x);

        // Explicit Casting Example 2
        double price = 499.99;
        int value = (int) price;
        System.out.println("Explicit Casting 2: " + value);
    }
}