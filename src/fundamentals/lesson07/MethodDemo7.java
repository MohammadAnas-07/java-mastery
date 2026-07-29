package fundamentals.lesson07;

public class MethodDemo7 {
    public static int add(int a, int b){
        return a + b;
    }

    public static int add(int a, int b, int c){
        return a + b + c;
    }

    public static void test(int x){
        System.out.println("int");
    }

    public static void test(double x){
        System.out.println("double");
    }

    public static void main(String[] args) {
        System.out.println(add(10,20));
        System.out.println(add(10,20,30));

        test('A'); // internally test(65) call-> test(int x)
    }
}

