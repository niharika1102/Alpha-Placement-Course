import java.util.*;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        //length is not equal
        if (s.length() != t.length()) {
            return false;
        }

        //Storing s in map
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        //Checking for characters of t in map
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) != null) {       //freq of ch is not null
                if (map.get(ch) == 1) {     //freq of char is 1, so in this iteration it will become 0 and will be removed from the hashmap
                    map.remove(ch);
                }
                else {     //freq of char > 1, so we decrement the value of freq
                    map.put(ch, map.get(ch) - 1);
                }
            }
            else {     //char is not found in hashmap
                return false;
            }
        }

        return map.isEmpty();
    }
    public static void main(String[] args) {
        String s = "lipid";
        String t = "pilid";

        System.out.println(isAnagram(s, t));
    }
}
