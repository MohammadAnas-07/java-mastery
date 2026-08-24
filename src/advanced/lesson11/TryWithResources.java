package advanced.lesson11;

import java.io.FileWriter;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter("notes.txt")){
            writer.write("Hello, this is my first file!!");
            System.out.println("File likh di gayi!");
        }catch(IOException e){
            System.out.println("Kuch galti ho gayi: " + e.getMessage());
        }
    }
}
