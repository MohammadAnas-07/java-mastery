/*
 * Lesson 05 - Switch Statement
 * Topic: Basic Switch
 * Author: Mohammad Anas
 */

package fundamentals.lesson05;

public class SwitchDemo {
    public static void main(String[] args) {
        System.out.println("=== Day Example ===");
        int day = 4;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
                
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;

            default:
              System.out.println("Invalid Day");
        }

        System.out.println("=== Grade Example ===");

        char grade = 'A';
        
        switch(grade){

            case 'A':
                System.out.println("Excellent");
                break;
            case 'B':
                System.out.println("Very Good");
                break;
            case 'C':
                System.out.println("Good");
                break;

                default:
                    System.out.println("Average");
        }

        System.out.println("=== Month Example ===");

        int month = 2;

          switch(month){

            case 1:
                System.out.println("January");
                break;

            case 2:
                System.out.println("February");
                break;

            case 3:
                System.out.println("March");
                break;

                default:
                    System.out.println("not found");

        }
      
    }
}
