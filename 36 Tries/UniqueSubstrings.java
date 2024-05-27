import java.util.*;

public class UniqueSubstrings {
    static class Node {
        Node[] children = new Node[26];    //to store any out of the 26 letters of the english alphabet
        boolean eow = false;

        Node() {
            //initializing children array with null at all indices
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    //Root node - always stays empty
    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;

        for (int level = 0; level < word.length(); level++) {
            char ch = word.charAt(level);
            int index = ch - 'a';
            if (curr.children[index] == null) {     //if char doesn't exist, we store it in child node
                curr.children[index] = new Node();
            }

            curr = curr.children[index];    //updating value of curr to the child node
        }

        curr.eow = true;    //word has finished
    }

    public static boolean search(String key) {
        Node curr = root;

        for (int level = 0; level < key.length(); level++) {
            char ch = key.charAt(level);
            int index = ch - 'a';

            if (curr.children[index] == null) {     //character doesn't exist in trie
                return false;
            }

            curr = curr.children[index];
        }

        return curr.eow == true;     //should reach end of word to return true
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {     //26 because there could be 26 possible children
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }

        return count + 1;   //+1 to count the root node
    }

    public static void main(String[] args) {
        String word = "ababab";

        //step 1: find all suffix
        //step 2: insert suffix into trie
        for(int i = 0; i < word.length(); i++) {
            String suffix = word.substring(i);
            insert(suffix);
        }

        //step 3: count total nodes of trie
        System.out.println(countNodes(root));
    }
}