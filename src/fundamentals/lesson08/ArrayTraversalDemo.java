package fundamentals.lesson08;

import java.util.Arrays;

public class ArrayTraversalDemo {
    public static void main(String[] args) {
        
        int[] marks = {85,92,78,64,89};

        for(int i = 0; i < marks.length; i++){
            System.out.println(marks[i]);
        }
        System.out.println(marks[0]); // 85
        System.out.println(marks.length); // 5



        int[] arr = {10,20,30,40};

        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] + 5;
        }
        System.out.println(Arrays.toString(arr)); // [15, 25, 35, 45]


        int[] arr1 = {2,4,6,8};
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = arr1[i] * arr1[i];
        }
        System.out.println(Arrays.toString(arr1)); // [4, 16, 36, 64]


        int[] arr2 = {1,2,3,4};
        for(int i = 1; i < arr2.length; i++){
            arr2[i] = arr2[i] + arr2[i - 1];
        }
        System.out.println(Arrays.toString(arr2)); // [1, 3, 6, 10]
    }
}
