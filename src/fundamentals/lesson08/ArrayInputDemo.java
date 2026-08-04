package fundamentals.lesson08;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayInputDemo {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        
        int size = sc.nextInt();
        
        int[] arr = new int[size];

        System.out.print("Enter " + size + " elements: ");

        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        sc.close();
        
    }
}