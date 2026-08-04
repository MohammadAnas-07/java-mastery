package fundamentals.lesson08;

import java.util.Arrays;

public class RightRotateDemo {
    public static void main(String[] args) {

        int[] arr = {10,20,30,40,50};

        rightRotateByK(arr ,2);

        System.out.println(Arrays.toString(arr));
    }

    public static void rightRotateByK(int[] arr, int k){

        // Optimization
        k = k % arr.length;

        // Rotate by 1, k times
        for(int i = 0;  i < k; i++){
            rightRotateByOne(arr);
        }
    }

    public static void rightRotateByOne(int[] arr){
        int last = arr[arr.length - 1];

        for(int i = arr.length - 1; i > 0; i--){
            arr[i] = arr[i - 1];
        }

        arr[0] = last;

    }
    
}

