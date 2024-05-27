import java.util.*;

public class PrefixProblem {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            else {
                curr.children[index].freq++;    //increase frequency if the character appears again
            }

            curr = curr.children[index];
        }

        curr.eow = true;
    }

    public static void findPrefix(Node root, String ans) {
        if (root == null) {
            return;
        }

        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < 26; i++) {     //we perform recursion on the whole children array
            if (root.children[i] != null) {    //we get a valid value
                findPrefix(root.children[i], ans + (char)(i + 'a'));     //we add the current character to the final answer
            }
        }
    }

    public static void main(String[] args) {
        String words[] = {"zebra", "dog", "duck", "dove"};

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        root.freq = -1;
        findPrefix(root, "");
    }
}
