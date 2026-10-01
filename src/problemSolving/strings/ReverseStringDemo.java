package problemSolving.strings;

public class ReverseStringDemo {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(revserseString(str));
    }

    public static String revserseString(String str){
        StringBuilder result = new StringBuilder();

        for(int i = str.length() - 1; i >= 0; i--){
            result.append(str.charAt(i));
        }
    return result.toString();
    }
}

