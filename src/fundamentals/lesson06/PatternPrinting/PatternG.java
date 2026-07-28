package fundamentals.lesson06.PatternPrinting;

public class PatternG {
    public static void main(String[] args) {
       for(int row = 4; row >= 1; row--){
        for(int i = 1; i <= row; i++){
            System.out.print(i);
        }
        System.out.println();
       }
    }
}
