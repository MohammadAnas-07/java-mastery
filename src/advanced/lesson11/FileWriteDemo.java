package advanced.lesson11;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteDemo {
    public static void main(String[] args) {
        try{
            FileWriter writer = new FileWriter("notes.txt");
            writer.write("Hello, this is my first file!");
            writer.close();
            System.out.println("File likh di gayi!");
        }catch(IOException e){
            System.out.println("kuch galti ho gayi: " + e.getMessage());
        }
    }
}


/*  1. CHECKED Exceptions
   → Compiler FORCE karta hai inhe handle karna (try-catch ya "throws")
   → Agar handle nahi kiya, COMPILE ERROR aata hai
   → Example: IOException (file operations), SQLException (database)

2. UNCHECKED Exceptions
   → Compiler FORCE nahi karta handle karna
   → Handle na karo to bhi COMPILE hoga (lekin runtime pe crash ho sakta hai)
   → Example: ArithmeticException, ArrayIndexOutOfBoundsException, NullPointerException */