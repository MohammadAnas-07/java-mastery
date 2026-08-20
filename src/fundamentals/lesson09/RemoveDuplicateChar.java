package fundamentals.lesson09;

public class RemoveDuplicateChar {
    public static void main(String[] args) {
        String str = "hello";
        String result = "";
        
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
            result+=str.charAt(i);
        }
        System.out.println(result);
    }
}