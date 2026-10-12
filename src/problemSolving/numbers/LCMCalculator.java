package problemSolving.numbers;

public class LCMCalculator {
    public static void main(String[] args) {
        int num1 = 6;
        int num2 = 4;
        System.out.println(findLCM(num1, num2));
    }

    public static int findGCD(int num1, int num2) {
        while(num2 != 0){
            int rem = num1 % num2;
            num1 = num2;
            num2 = rem;
        }

        return num1;
    }

    public static int findLCM(int num1, int num2){
        if(num1 == 0 || num2 == 0) return 0;
        return (num1 / findGCD(num1, num2)) * num2;
    }
}
