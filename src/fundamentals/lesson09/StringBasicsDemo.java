package fundamentals.lesson09;

public class StringBasicsDemo {
    public static void main(String[] args) {
        String name = "Anas";
        name = name.concat(" Ansari");
        System.out.println(name);

        for(int i = 0; i < name.length(); i++){
            System.out.println(name.charAt(i));
        }

        System.out.println("Name: " + name);
        System.out.println("Length: " + name.length());
        System.out.println("First Character: " + name.charAt(0));
        System.out.println("Third Character: " + name.charAt(2));

        String a = new String("Anas");
        String b = new String("Anas");

        System.out.println(a == b); //false
        System.out.println(a.equals(b)); //true

        String s = "Java";
        s = s.toUpperCase();// JAVA
        System.out.println(s);

        String lang = "Java";
        lang = lang.substring(0,2);// Ja
        System.out.println(lang);

        String c = "Java";
        String d = "Programming";
        /* String result = c + " " + d;
        System.out.println(result);  *///Java Programming

        String result = "Java" + 10 + 20;
        System.out.println(result); //Java1020


        String language = "Java";
        char[] chars = language.toCharArray();
        System.out.println(chars.length); // 4
        System.out.println(chars[2]); //v


       

    }
    
}
