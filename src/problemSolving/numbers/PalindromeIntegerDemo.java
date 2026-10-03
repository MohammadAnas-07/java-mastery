package problemSolving.numbers;

public class PalindromeIntegerDemo {
    public static void main(String[] args) {
        int num = 12321;
        System.out.println(isPalindrome(num));
    }
    public static boolean isPalindrome(int num){
        int original = num;
        int result = 0;

        while(num > 0){
            int digit = num % 10;
            result = result * 10 + digit;
            num = num / 10;
        }

        return original == result;
    }
}
