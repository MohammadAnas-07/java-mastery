package fundamentals.lesson08;

import java.util.Arrays;

public class SelectionSortDemo {
    public static void main(String[] args) {

        int[] arr = {4,3,2,1};

        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
        
    }
    
    public static void selectionSort(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n - 1; i++){

            int minIndex = i;

             // Find minimum
            for(int j = i + 1; j < n; j++){
                
                if(arr[minIndex] > arr[j]){
                    minIndex = j; // only update index
                }
            }
            // One swap after finding minimum
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
