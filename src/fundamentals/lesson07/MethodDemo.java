package fundamentals.lesson07;

public class MethodDemo {
    public static void add(){
        System.out.println("Addition Method");
    }
    
    public static void subtract(){
        System.out.println("Subtraction Method");
    }

    public static void multiply(){
        System.out.println("Multiplication Method");
    }
    public static void main(String[] args) {
        System.out.println("Start");
        multiply();
        add();
        subtract();
        System.out.println("End");
      
    }
}
