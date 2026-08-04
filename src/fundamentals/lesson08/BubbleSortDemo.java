package fundamentals.lesson08;
import java.util.Arrays;;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = {7,2,5,1};

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }
    
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int pass = 1; pass <= n - 1; pass++){
            for(int i = 0; i < n - pass; i++){
                if(arr[i] > arr[i + 1]){ // adjacent array compare
                    int temp = arr[i]; // swap
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }

            }

        }
    }
}
