package fundamentals.lesson08;

public class ArrayEqualityDemo {
    public static void main(String[] args) {
        int[] arr1 = {10,20,30};
        int[] arr2 = {10,20,30};

        System.out.println(arr1 == arr2); // false
        // java values nahin addresses compare krta hai


        // Arrays.equals()

        int[] marks1 = {10,20,30};
        int[] marks2 = {10,20,30};

        boolean isEqual = true;

        if(marks1.length != marks2.length){
            isEqual = false;
        }else{
            for(int i = 0; i < marks1.length; i++){
                if(marks1[i] != marks2[i]){
                    isEqual = false;
                    break; 
                }
            }
        }
        System.out.println("Arrays Equal: " + isEqual); // true

    }
}
