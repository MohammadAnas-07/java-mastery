package fundamentals.lesson04;

public class TernaryDemo {
    public static void main(String[] args) {
        // Voting Criteria
        int age = 25;
        String result = (age >= 18) ? "Eligible" : "Not Eligible";
        System.out.println(result);

        // Even-Odd
        int num = 15;
        String ans = (num % 2 == 0) ? "Even" : "Odd";
        System.out.println(ans);

        //Pass-Fail
        int marks = 30;
        String res = (marks >=33) ? "Pass" : "Fail";
        System.out.println(res);
    }
}
