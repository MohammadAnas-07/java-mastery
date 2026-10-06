package problemSolving.numbers;

public class Factorial {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(factorial(num));
    }
    public static int factorial(int num){
        int result = 1;

        for(int i = 1; i <= num; i++){
            result*=i;
        }
        return result;
    }
}
