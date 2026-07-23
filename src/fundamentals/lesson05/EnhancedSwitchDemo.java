package fundamentals.lesson05;

public class EnhancedSwitchDemo {
    // example -1
    public static void main(String[] args) {
        int month = 2;

switch (month) {
    case 12, 1, 2 -> System.out.println("Winter");
    case 3, 4, 5 -> System.out.println("Summer");
    default -> System.out.println("Other");
}

// example - 2
int day = 10;

switch (day) {
    case 1 -> System.out.println("Monday");
    case 2 -> System.out.println("Tuesday");
    default -> System.out.println("Invalid");
}

    }

    
}
