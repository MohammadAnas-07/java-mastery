package problemSolving.numbers;

public class Armstrong {
    public static void main(String[] args) {

        int num = 153;

        System.out.println(isArmstrong(num));
    }

    public static boolean isArmstrong(int num){

        if(num < 0) return false;

        int count = (int) Math.log10(num) + 1;

        int original = num;
        int sum = 0;

        while(num > 0){
            int digit = num % 10;

            sum+=Math.pow(digit, count);

            num/=10;
        }
        return original == sum;
    }
}
