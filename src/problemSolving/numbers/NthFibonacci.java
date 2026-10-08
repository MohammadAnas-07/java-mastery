package problemSolving.numbers;

public class NthFibonacci {
    public static void main(String[] args) {

        int n = 7;

        System.out.println(nthFibonacci(n));
    }

    public static int nthFibonacci(int n){

        if(n <= 1){
            return n;
        }

        int firstNum = 0;
        int secondNum = 1;

        while(n > 1){
            int nextNum = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = nextNum;
            n--;
        }

        return secondNum;
    }
}
