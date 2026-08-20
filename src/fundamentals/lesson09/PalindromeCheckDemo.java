package fundamentals.lesson09;

public class PalindromeCheckDemo {
    public static void main(String[] args) {
         String str = "a";
         boolean result = isPalindrome(str);
         System.out.println("is a Palindrome " + result);
    }

    public static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


