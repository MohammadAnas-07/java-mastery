package fundamentals.lesson08;

import java.util.Arrays;

public class ArrayDeclarationDemo {
    public static void main(String[] args) {

        int[] arr = new int[2];

        arr[0] = 10;
        arr[1] = 20;

        System.out.println(arr.length);
       /*  System.out.println(arr[2]); */
        System.out.println("Program end");


        int[] marks = new int[3];
        System.out.println(marks.length);
        marks = new int[5];
        System.out.println(marks.length); // 5


        int[] res = new int[3];
        res[0] = 10;
        res = new int[5];
        System.out.println(res[0]); // 0


        int[] arr1 = new int[3];
        int[] arr2 = arr1;
        arr2[0] = 99; 
        System.out.println("arr1[0]: " + arr1[0]); // 99
        arr1 = new int[5];
        System.out.println(arr1.length); // 5
        System.out.println(Arrays.toString(arr2)); // [99,0,0]
        System.out.println(Arrays.toString(arr1)); // [0,0,0,0,0]
        System.out.println(arr1[0]); // 0
        System.out.println(arr2[0]); // 99
        System.out.println(arr2.length); // 3


        int[] a = {1,2,3};
        int[] b = a;
        b[1] = 100;
        System.out.println(Arrays.toString(a)); // [1,100,3]
        System.out.println(Arrays.toString(b)); // [1,100,3]
    }
}
