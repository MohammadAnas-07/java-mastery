package fundamentals.lesson06.PatternPrinting;

public class PatternH {
    public static void main(String[] args) {
        for(int row = 1; row <= 4; row++){
            for(int i = 1; i <= row; i++){
                System.out.print(row);
            }
        System.out.println();
        }
    }
}
