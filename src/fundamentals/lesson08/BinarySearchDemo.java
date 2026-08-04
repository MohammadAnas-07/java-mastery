package fundamentals.lesson08;

public class BinarySearchDemo {
    public static void main(String[] args) {
        
        int[] arr = {10,20,30,40,50,60,70};

        int target = 50;

        int index = binarySearch(arr, target);

        System.out.println(" at index = " + index);
    }

    public static int binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(target > arr[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
            
        }
        return - 1;
    }
}

