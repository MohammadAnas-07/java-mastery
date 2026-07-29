package fundamentals.lesson07;

public class MethodDemo3 {
    public static int add(int a, int b){
        return a + b;
        
    }

    public static int square(int number){
        return number * number;
    }

    public static int multiply(int x, int y){
        return x * y;
    }
    public static void main(String[] args) {
        int sum = add(10,20);
        System.out.println("sum: " + sum);

        int squareResult = square(5);
        System.out.println("squareResult: " + squareResult);

        int product = multiply(6,7);
        System.out.println("product: " + product);

        System.out.println(multiply(5,5));// 25
        System.out.println(add(10,multiply(2,5)));//20 Method Composition.
    }
}
