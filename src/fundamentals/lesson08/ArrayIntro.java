package fundamentals.lesson08;

import java.util.Arrays;

public class ArrayIntro {
    public static void main(String[] args) {
        int[] marks = {85,92,78,64,89};

        System.out.println(marks[0]);
        System.out.println(marks[3]);

        

        int [] arr = new int[4];

        arr[1] = 20;
        arr[3] = 50;
        arr[0] = 10;
        arr[2] = arr[1] + arr[3];

        System.out.println("arr[2]: " + arr[2]);
        System.out.println(Arrays.toString(arr)); // [10,20,70,50]

        int [] res = new int[5];

        res[0] = 5;
        res[1] = res[0] * 2;
        res[2] = res[1] + 5;
        res[3] = res[2] - res[0];
        res[4] = res[3] / 2;

        System.out.println("res: " + Arrays.toString(res));

    }
}
