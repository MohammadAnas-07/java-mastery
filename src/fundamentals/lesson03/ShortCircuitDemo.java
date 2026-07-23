package fundamentals.lesson03;

public class ShortCircuitDemo {
    public static void main(String[] args) {
        int x = 5;
        /* System.out.println(false && ++x > 5); */
        System.out.println(x);

        int a = 10;
        System.out.println(a < 5 || ++a > 10);

        int c = 5;
        System.out.println(c++ * 2 + ++c);
    }
}
