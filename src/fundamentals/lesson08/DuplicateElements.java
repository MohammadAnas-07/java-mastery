package fundamentals.lesson08;

public class DuplicateElements {
    public static void main(String[] args) {

        int[] arr = {2,3,2,1,3,5,2};

        duplicateElements(arr);

    }
        public static void duplicateElements(int[] arr){
            for(int i = 0; i < arr.length; i++){
        
               // Flag to check whether current element
               // has already been processed
               boolean alreadyCounted = false;
        
               // Check previous elements
               // If current element is already seen,
               // skip counting it again
               for(int j = 0; j < i; j++){
                   if(arr[i] == arr[j]){
                       alreadyCounted = true;
                       break;
                   }
               }
        
               // Skip duplicate elements
               if(alreadyCounted){
                   continue;
               }
        
               // Count frequency of current element
               int count = 0;
        
               // Scan the entire array
               // and count occurrences
               for(int j = 0; j < arr.length; j++){
                   if(arr[j] == arr[i]){
                       count++;
                   }
               }
               if(count > 1){
                   // Print element with its duplicate
                   System.out.println(arr[i]);
               }
           }
        }
    }
