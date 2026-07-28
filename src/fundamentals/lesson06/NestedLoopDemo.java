package fundamentals.lesson06;

public class NestedLoopDemo {
    public static void main(String[] args) {
        for(int row = 1; row <= 3; row++){
            for(int col = 1; col <= 4; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
 
        for(int i = 1; i <= 2; i++){
            for(int j = 1; j <= 3; j++){
                System.out.print(i + "" + j + " ");
            }
            System.out.println();
        } 

       
    }
}
