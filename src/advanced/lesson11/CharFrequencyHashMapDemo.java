package advanced.lesson11;

import java.util.HashMap;

public class CharFrequencyHashMapDemo {
    public static void main(String[] args) {
         String str = "hello";
        HashMap<Character, Integer> freq = new HashMap<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(freq.containsKey(ch)){
                int oldValue = freq.get(ch);
                freq.put(ch,oldValue + 1);
            }else{
                freq.put(ch,1);
            }
        }

        System.out.println(freq);
       
    }
}

