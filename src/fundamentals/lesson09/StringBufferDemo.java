package fundamentals.lesson09;

public class StringBufferDemo {
    public static void main(String[] args) {
        
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(" World");
        System.out.println(sbf);
    }
}
