package fundamentals.lesson04;

public class ElseIfDemo {
    public static void main(String[] args) {
        
         int marks = 45;

            if(marks >= 90){
                System.out.println("A");
            }else if(marks >=80){
                System.out.println("B");
            }else if(marks >=70){
                System.out.println("C");
            }else if(marks >=50){
                System.out.println("D");
            }else{
                System.out.println("Fail");
            }

            int result = 90;
            if(result >=80){
                System.out.println("B");
            }else if(result >=90){
                System.out.println("A");
            }
    }
    
}
