package fundamentals.lesson09;

public class ReverseStringDemo {
    public static void main(String[] args) {
        String str = "Java";
        String result = "";

        for(int i = str.length() - 1 ; i >=0; i--){
            result+=str.charAt(i);

        }
        System.out.println(result);
    }
    
}
