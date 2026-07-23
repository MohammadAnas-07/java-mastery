package fundamentals.lesson05;

public class SwitchVsIfElseDemo {

    // Multiple range of variables that's why if-else
    public static void main(String[] args) {
        int age = 25;
        if(age >= 18 && age <= 60){
            System.out.println("Adult");
        }else{
            System.out.println("Not Adult");
        }

        // fixed value we just have to check the value, its more readable for many choices

        int day = 2;

        switch(day){
            case 1,3,4 -> System.out.println("Not matched");
            case 2 -> System.out.println("matched");
        }
    }
}
