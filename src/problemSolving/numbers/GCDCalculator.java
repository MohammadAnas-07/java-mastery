package problemSolving.numbers;

public class GCDCalculator {
    public static void main(String[] args) {

        int num1 = 48;
        int num2 = 18;

        System.out.println(findGCD(num1, num2));
    }

    public static int findGCD(int num1, int num2){

        while(num2 != 0){

            int remiander = num1 % num2;
            num1 = num2;
            num2 = remiander;
        }

        return num1;
    }
}
