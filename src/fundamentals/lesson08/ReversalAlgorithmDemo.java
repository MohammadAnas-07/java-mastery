package fundamentals.lesson08;

import java.util.Arrays;

public class ReversalAlgorithmDemo {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};

        leftRotateByK(arr, 2);
        rightRotateByK(arr, 2);
        
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr, int start, int end){

        while(start < end){

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

    }

    public static void leftRotateByK(int[] arr, int k){

        //Optimization
        k = k % arr.length;

        //Step 1
        reverse(arr, 0, k- 1);

        //Step 2
        reverse(arr, k, arr.length - 1);
        //Step 3
        reverse(arr, 0, arr.length - 1);

    }

    public static void rightRotateByK(int[] arr, int k){
        k = k % arr.length;

        reverse(arr, 0, arr.length - k - 1);

        reverse(arr, arr.length - k, arr.length - 1);
        
        reverse(arr, 0, arr.length - 1);
    }
}
