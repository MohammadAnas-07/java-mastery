package fundamentals.lesson06;

public class breakDemo {
    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++){
            if(i == 6){
                break;
            }
            System.out.println(i);
        }

        for(int a = 20; a >= 1; a--){
            if(a == 15){
                break;
            }
            System.out.println(a);
        }
    }
}
