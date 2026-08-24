package oop.lesson10;

public class ExceptionHandling {
    public static void main(String[] args) {
        
        try{
            int[] arr = {1,2,3};
            System.out.println(arr[5]);
        } catch(ArithmeticException e){
            System.out.println("Math error!");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array index galat hai!");
        }
        finally{
            System.out.println("This always runs!");
        }
    }
}
