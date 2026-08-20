package fundamentals.lesson09;

public class DuplicateCharacters {
    public static void main(String[] args) {
        String str = "hello";

        for(int i = 0; i < str.length(); i++){ // Loop 1 (outer)
            boolean alreadyCounted = false;

             for(int j = 0; j < i; j++){ // Loop 2 (inner)
                if(str.charAt(i) == str.charAt(j)){
                    alreadyCounted = true;
                    break;
                }
            }
            if(alreadyCounted){
                continue;
            }

            int count = 0;

            for(int j = 0; j < str.length(); j++){ // Loop 3 (inner)
                if(str.charAt(i) == str.charAt(j)){
                    count++;
                }
            }
            if(count > 1){
                System.out.println(str.charAt(i));
            }

        }
    }
}
