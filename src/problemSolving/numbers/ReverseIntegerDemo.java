package problemSolving.numbers;

public class ReverseIntegerDemo {
    public static void main(String[] args) {
        int num = 4567;
        System.out.println(reverseInteger(num));
    }

    public static int reverseInteger(int num){
        int result = 0;

        while(num > 0){
            int digit = num % 10;
            result = result * 10 + digit;
            num = num / 10;
        }

        return result;
    }
}
