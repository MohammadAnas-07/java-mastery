package fundamentals.lesson06.PatternPrinting;

public class PatternI {
    public static void main(String[] args) {
        for(int row = 1; row <= 4; row++){
            char ch = (char) ('A' + (row - 1));
            
                for(int i = 1; i <= row; i++){
                    System.out.print(ch);
                }
                
            
            System.out.println();
        }
    }
}
