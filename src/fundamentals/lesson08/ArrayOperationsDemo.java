package fundamentals.lesson08;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperationsDemo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter size of an array: ");
        int size = sc.nextInt();
        
        int[] arr = new int[size];
        
        System.out.println("Enter " + size + " elements: ");

        int sum = sumOfArray(arr, sc);

        double avg = averageOfArray(arr, sum); 
        
        int max = findMax(arr); 
        
        int min = findMin(arr);
        
        System.out.println("Your Array: " + Arrays.toString(arr));
        System.out.println("Sum = " + sum);
        System.out.println("Avg = " + avg);
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
    }
    
    public static int sumOfArray(int[] arr, Scanner sc){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        return sum; 
    }
    
    public static double averageOfArray(int[] arr, int sum){
        return (double) sum / arr.length;
    }
    
    public static int findMax(int[] arr) {
        int max = arr[0]; // Pehle element ko max maan lo
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // Naya max mila toh update karo
            }
        }
        return max; 
    }
    
    public static int findMin(int[] arr){
        int min = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}
