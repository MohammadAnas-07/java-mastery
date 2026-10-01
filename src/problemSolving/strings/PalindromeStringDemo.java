package problemSolving.strings;

public class PalindromeStringDemo {
    public static void main(String[] args) {
        String str = "level";
        System.out.println(palindromeString(str));
    }

    public static boolean palindromeString(String str){
        StringBuilder reverse = new StringBuilder();

        for(int i = str.length() - 1; i >= 0; i--){
            reverse.append(str.charAt(i));
        }

        return str.equals(reverse.toString());
    }
}
