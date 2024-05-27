import java.util.*;

public class FirstNonRepeatingChar {
    public static void desiredChar(String str) {
        int freq[] = new int[26];      //To track the freq of each character in the alphabet
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);      //Adding the character to the queue
            freq[ch - 'a']++;      //ch - 'a' is used to obtain the index of the array according to the positon of the letter in the english alphabet. This step is to increment the frequency of the character

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {     //If the queue has elements and the freq of the head character is >1, it cant be the first non-repeating character. So, remove it.
                q.remove();
            }

            //When the loop terminates, two cases are possible.

            //case 1 - queue is empty now, so we have no first non-repeating character
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            }

            //case 2 - the first non-repeating character is found
            else {
                System.out.print(q.peek() + " ");
            }
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";

        desiredChar(str);
    }
}