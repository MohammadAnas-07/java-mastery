package fundamentals.lesson04;

public class NestedIfDemo {
    public static void main(String[] args) {
        int age = 20;
        boolean hasDegree = true;

        if(age>=18){
            System.out.println("Age Verified");

            if(hasDegree){
                System.out.println("Degree Verified");

            }
        }
        System.out.println("Done");
    }
}
