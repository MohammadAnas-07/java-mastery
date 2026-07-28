package fundamentals.lesson06;

public class continueDemo {
    public static void main(String[] args) {
        for(int i = 1; i <= 20; i++){
            if(i % 2 == 0){
                continue;
            }
            System.out.print(i + " ");
        }
        for(int a = 1; a <= 10; a++){
            if(a == 5){
                continue;
            }
            System.out.println(a);
        }
    }
}
