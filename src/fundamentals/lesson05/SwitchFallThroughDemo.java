package fundamentals.lesson05;

public class SwitchFallThroughDemo {
    public static void main(String[] args) {
        
          int x = 2;

        switch (x) {
            case 1:
                System.out.println("A");
                

                case 2:
                    System.out.println("B");
                
                    case 3:
                        System.out.println("C");
            

                // Example - intentionally not written break;
                
                char grade = 'B';

                switch(grade){
                    case 'A':
                    case 'B':
                    case 'C':

                    System.out.println("Pass");
                    break;

                    case 'D':
                        System.out.println("Average");
                        break;

                        default:
                            System.out.println("Fail");
                }
        }

      
    }
    
}
