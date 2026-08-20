package fundamentals.lesson09;

public class AnagramDemo {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        boolean result = isAnagram(str1, str2);
        System.out.println(result);

    }

    public static int countChar(String str, char ch){
        int count = 0;
        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ch){
                count++;
            }
        }
        return count;
    }

    public static boolean isAnagram(String str1, String str2){
        // Step 1: length check
        if(str1.length() != str2.length()){
            return false; // Agar dono strings ki length alag hai → false
        }

        // Step 2: har character ke liye count comapare kro
        for(int i = 0; i < str1.length(); i++){
            char ch = str1.charAt(i);

            int count1 = countChar(str1, ch);
            int count2 = countChar(str2, ch);

            if(count1 != count2){
                return false; // Agar kisi bhi character ka count mismatch hua → false
            }
        }
        return true; //Agar sab match hue → true
    }
}
