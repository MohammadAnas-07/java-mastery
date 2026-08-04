package fundamentals.lesson08;

import java.util.Arrays;

public class CopyArrayDemo {
    public static void main(String[] args) {
        
        int[] arr1 = {10,20,30};
        int[] arr2 = new int[arr1.length];

        for(int i = 0; i < arr1.length; i++){
             arr2[i] = arr1[i];
             arr2[1] = 999;
            }
            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));


            int[] a = {1,2,3};
            int[] b = a;

            int[] c = new int[a.length];

            for(int i = 0; i < a.length; i++){
                c[i] = a[i];
            }
            b[0] = 100;
            c[1] = 200;

            System.out.println(Arrays.toString(a)); // [100, 2, 3]
            System.out.println(Arrays.toString(b)); // [100, 2, 3]
            System.out.println(Arrays.toString(c)); // [1, 200, 3]


            int[] x = {5,10};
            int[] y = x;
            int[] z = new int[2];
            z= x; // this line changed the game
            z[1] = 99;
            System.out.println(Arrays.toString(x)); // [5,99]
            System.out.println(Arrays.toString(y)); // [5,99]
            System.out.println(Arrays.toString(z)); // [5,99]
    }
}
