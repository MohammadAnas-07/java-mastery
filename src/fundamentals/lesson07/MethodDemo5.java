package fundamentals.lesson07;

public class MethodDemo5 {
    public static void studentInfo(String name, int age, double cgpa){
        System.out.println("Name :" + name);
        System.out.println("Age :" + age);
        System.out.println("CGPA :" + cgpa);
    }

    public static void main(String[] args) {
        studentInfo("Anas", 21, 7.0);
        System.out.println("--------");
        studentInfo("Rahul", 20, 8.5);
    }
}
