package fundamentals.lesson08;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter " + size + " elements:");
        
        // 1. Input 
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(arr));

        System.out.print("Enter number to search: ");
        
        // 2. Target
        int target = sc.nextInt();

        // 3. Search 
        int index = linearSearch(arr,target); 

        if(index == -1){
            System.out.println("Not Found");
        }else{
            System.out.println("Found at index " + index);
        }
        
    }
    
    public static int linearSearch(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
    
            if(arr[i] == target){
                return i;
        
    }
  }
  return -1;
}
}