package fundamentals.lesson06.PatternPrinting;

public class PatternE {
    public static void main(String[] args) {
      for(int row = 1; row <= 4; row++){
        for(int i = 3; i >= row; i--){
            System.out.print(" ");
        }
        for(int j = 1; j <= row; j++){
            System.out.print("*");
        }
        System.out.println();
      }
    }
}
