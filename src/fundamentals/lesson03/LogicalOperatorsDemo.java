package fundamentals.lesson03;

public class LogicalOperatorsDemo {

    public static void main(String[] args) {

        boolean hasMoney = true;
        boolean hasTime = false;

        System.out.println("AND (&&): " + (hasMoney && hasTime));
        System.out.println("OR (||): " + (hasMoney || hasTime));
        System.out.println("NOT (!hasMoney): " + (!hasMoney));
        System.out.println("NOT (!hasTime): " + (!hasTime));

        // Example
        System.out.println(!(10 > 5));
    }
}