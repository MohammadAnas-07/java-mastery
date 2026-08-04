package fundamentals.lesson08;

import java.util.Arrays;

public class ReverseArrayDemo {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};

        System.out.println("Original Array: " + Arrays.toString(arr));

        reverseArray(arr);

        System.out.println("Reversed Array: " + Arrays.toString(arr));
                
    }
    
    public static void reverseArray(int[] arr){
        int left = 0;
        int right = arr.length - 1;

            while(left < right){
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;

                    left++;
                    right--;
                }
            
        }

    }
