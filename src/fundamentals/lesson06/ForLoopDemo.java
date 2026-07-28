package fundamentals.lesson06;

public class ForLoopDemo {
    public static void main(String[] args) {
        System.out.println("1 to 10");
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
        }

        System.out.println("10 to 1");
        for(int a = 10; a >= 1; a--){
            System.out.println(a);
        }

        System.out.println("even no. from 2 to 20");
        for(int e = 2; e <= 20; e+=2){
            System.out.println(e);
        }

        System.out.println("odd no. 1 to 19");
        for(int o = 1; o <=19; o+=2){
            System.out.println(o);
        }
        
        int sum = 0;
        for(int c = 1; c <=100; c++){
            sum+=c;
        }
        System.out.println("1 to 100 ka sum: "+ sum);
    }
}
