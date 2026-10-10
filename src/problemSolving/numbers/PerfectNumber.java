package problemSolving.numbers;

public class PerfectNumber {
    public static void main(String[] args) {

        int num = 6;

        System.out.println(isPerfectNumber(num));
    }

    public static boolean isPerfectNumber(int num) {

        int sum = 0;

        for(int i = 1; i < num; i++){
            if(num % i == 0){
                sum+=i;
            }
        }

        return sum == num;
    }
}
