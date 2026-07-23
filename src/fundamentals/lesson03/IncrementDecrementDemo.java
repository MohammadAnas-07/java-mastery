package fundamentals.lesson03;

public class IncrementDecrementDemo {
    public static void main(String[] args) {
        
        int x = 5;
        System.out.println(x++);
        System.out.println(x);

        int y = 5;
        System.out.println(++y);
        System.out.println(y);

        //Example  -1
        int a = 10;
        System.out.println(a++ + ++a);

        // Example -2
        int num1 = 5;
        int num2 = num1++;
        System.out.println(num1);
        System.out.println(num2);


        int  b = 10;
        System.out.println(b--);
        System.out.println(b);

        int c = 11;
        System.out.println(--c);
        System.out.println(c);


        // Example -3
        int count = 10;
        count = count++;
        System.out.println("count: " + count); // 10

        int cc = 5;

        System.out.println(cc++ + cc++); // 11



    }
}
