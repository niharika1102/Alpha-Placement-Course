import java.util.*;

public class WordBreakProblem {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
 
        for (int level = 0; level < word.length(); level++) {
            char ch = word.charAt(level);
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }

            curr = curr.children[index];
        }

        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;

        for (int level = 0; level < key.length(); level++) {
            char ch = key.charAt(level);
            int index = ch - 'a';

            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return curr.eow == true;
    }

    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }

        for (int i = 1; i <= key.length(); i++) {    //we start from 1 because when we define the substrings, the last index is not inclusive in the substring definition
            //if the letter is found in the trie and the recursive function also returns true for all other cases, we return true
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {  //first index of the key is the first substring and the leftover part is the second substring
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        String key = "ilikesung";

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(wordBreak(key));
    }
}
