package problemSolving.numbers;

public class Fibonacci {
    public static void main(String[] args) {

        int n = 7;

        fibonacciSeries(n);
    }

    public static void fibonacciSeries(int n){

        int firstNum = 0;
        int secondNum = 1;

        for(int i = 0; i < n; i++){
            System.out.println(firstNum);
            int nextNum = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = nextNum;
        }
    }
}
