package fundamentals.lesson04;

public class IfElseDemo {
    public static void main(String[] args) {
        // Voting Eligibility
        int age = 15;
    
        if(age >= 18){
            System.out.println("Eligible");
        }else{
            System.out.println("Not eligible");
         }
         System.out.println("Program End");

        // Odd-Even Check
         int number = 10;
         if(number % 2 ==0){
            System.out.println("Even");
         }else{
            System.out.println("Odd");
         }

         // Pass-Fail
       /*   int marks = 85;
         if(marks>= 33){
             System.out.println("Congratulation you're Pass");
        }else{
            System.out.println("You're Failed");
         } */

           


    }
}
