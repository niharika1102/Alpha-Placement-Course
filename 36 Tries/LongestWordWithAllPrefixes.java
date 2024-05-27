import java.util.*;

import org.w3c.dom.Node;

public class LongestWordWithAllPrefixes {
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

    public static String ans = "";    //storing final answer

    public static void longestString(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                char ch = (char)(i + 'a');
                temp.append(ch);

                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                longestString(root.children[i], temp);

                //backtracking
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String words[] = {"a", "banana", "app", "appl", "apple", "apply", "ap"};

        for (String w: words) {
            insert(w);
        }

        StringBuilder temp = new StringBuilder("");

        longestString(root, temp);
        System.out.println(ans);
    }
}
