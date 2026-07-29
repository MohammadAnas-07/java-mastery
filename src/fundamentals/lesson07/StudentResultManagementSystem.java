package fundamentals.lesson07;

public class StudentResultManagementSystem {

    public static void showMenu() {

        System.out.println("========== Student Result System ==========");
        System.out.println("1. Calculate Percentage");
        System.out.println("2. Show Grade");
        System.out.println("3. Check Pass/Fail");
        System.out.println("4. Print Marksheet");
        System.out.println("5. Print Star Pattern");
        System.out.println("6. Exit");

    }

    public static double calculatePercentage(int obtainedMarks, int totalMarks) {
         return (obtainedMarks * 100.0) / totalMarks;

    }

    public static char calculateGrade(double percentage) {
        if(percentage >= 90.0){
            return 'A';
        }
        else if(percentage >= 80.0){
            return 'B';
        }
        else if(percentage >= 70.0){
            return 'C';           
        }
        else if(percentage >= 60.0){
            return 'D';
        }else{
            return 'F';
    }
}

    public static boolean checkPassOrFail(double percentage) {
       return percentage >= 33;

    }

    public static void printMarksheet(String name, int rollNo, int obtainedMarks, int totalMarks) {
        double percentage = calculatePercentage(obtainedMarks,totalMarks);
        char grade = calculateGrade(percentage);
        boolean passed = checkPassOrFail(percentage);

        System.out.println("========== MARKSHEET ==========");
        System.out.println("Name          : " + name);
        System.out.println("Roll No       : " + rollNo);
        System.out.println("Marks         : " + obtainedMarks + " / " + totalMarks);
        System.out.printf("Percentage    :   %.2f%%\n", percentage);
        System.out.println("Grade         : " + grade);
        System.out.println("Result        : " + (passed ? "Pass" : "Fail"));
        System.out.println("================================");



    }

    public static void printStarPattern(int rows) {
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

       showMenu();
       
       double percentage = calculatePercentage(450,500);
       System.out.println("Percentage: " + percentage);

       char grade = calculateGrade(87.5);
       System.out.println("Grade: " + grade);

       boolean passed = checkPassOrFail(90.0);
       System.out.println(passed);

       System.out.println("--- Test Marksheet Printing ---");
       printMarksheet("Anas", 101, 450, 500);
       printMarksheet("Rahul", 102, 380, 500);
       System.out.println();

       System.out.println("--- Test Star Pattern (5 Rows) ---");
       printStarPattern(5);
    }
}

