package fundamentals.lesson08;

import java.util.Arrays;

public class LeftRotateDemo {

    public static void main(String[] args) {

        int[] arr = {10,20,30,40,50};

        leftRotateByK(arr, 2);

        System.out.println(Arrays.toString(arr));
    }

    public static void leftRotateByK(int[] arr, int k){

        // Optimization
        k = k % arr.length;

        // Rotate by 1, k times
        for(int i = 0; i < k; i++){
            leftRotateByOne(arr);
        }
    }

    public static void leftRotateByOne(int[] arr){

        int first = arr[0];

        for(int i = 0; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = first;
    }
} 