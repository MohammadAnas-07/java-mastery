package fundamentals.lesson07;

public class OverloadingDemo {
    
    public static void print(int x){
        System.out.println("Integer");
    }

    public static void print(double x){
        System.out.println("Double");
    }

    public static void main(String[] args) {
        
        print(10);
        print(10.5);
    }
}
