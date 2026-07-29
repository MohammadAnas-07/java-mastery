package fundamentals.lesson07;

public class MethodDemo6 {
    public static void test(int x){
        x = 100;
        System.out.println(x);
    }

    public static void main(String[] args) {
        int x = 50;

        test(x); // 100

        System.out.println(x); // 50
    }
}
