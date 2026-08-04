package fundamentals.lesson08;


public class SecondLargestDemo {
    public static void main(String[] args) {
        int[] arr = {10,50,20,80,30};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i = 1; i < arr.length; i++){

            if(arr[i] > largest){
                secondLargest = largest; 
                largest = arr[i];
            }else if(arr[i] < largest && arr[i] > secondLargest){
                secondLargest = arr[i];
            }

        }
        System.out.println(String.valueOf("Largest = " + largest));
        System.out.println(String.valueOf("Second Largest = " + secondLargest));
    }
}
