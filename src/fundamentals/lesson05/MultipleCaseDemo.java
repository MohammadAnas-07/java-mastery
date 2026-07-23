package fundamentals.lesson05;

public class MultipleCaseDemo {
    public static void main(String[] args) {
        
        int month = 2;

switch (month) {

    case 12:
    case 1:
    case 2:
        System.out.println("Winter");
        break;

    case 3:
    case 4:
    case 5:
        System.out.println("Summer");
        break;

    default:
        System.out.println("Invalid Month");
}


      char Grade = 'A';

        switch (Grade) {
            case 'A':
            case 'B':
                System.out.println("Excellent:");

                case 'C':
                    System.out.println("Good:");

                    default:
                        System.out.println("Average:");
                
        
            
        }
    }

    
}
