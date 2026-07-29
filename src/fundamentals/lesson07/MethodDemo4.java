package fundamentals.lesson07;

public class MethodDemo4 {
    public static int add(int a, int b){
        return a + b;
    }

    public static int doubleValue(int x){
        return x * 2;
    }

    public static int cube(int number){
        return number * number * number;
    }

    public static void main(String[] args) {
        
        int result = doubleValue(add(5,10));
        System.out.println(result);//30

        System.out.println(cube(3)); //27
        System.out.println(cube(5)); // 125
        System.out.println(add(cube(2), doubleValue(5)));// 8 + 10 = 18
    }
}
