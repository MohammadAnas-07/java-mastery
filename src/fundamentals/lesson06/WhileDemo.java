package fundamentals.lesson06;

public class WhileDemo {
    public static void main(String[] args) {
        
        int i = 1;

        while (i <= 5) {
            System.out.println(i);
            i++;
        }

        int lang = 1;

        while(lang <= 5){
            System.out.println("Java");
            lang++;
        }

        // 2 se 10 tak even numbers print karo.
        int num = 1;

        while (num <=10) {
            System.out.println(num);
            num+=2;
        }
    }
}
