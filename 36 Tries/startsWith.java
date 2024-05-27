import java.util.*;

public class startsWith {
    static class Node {
        Node children[] = new Node[26];
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
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
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
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            int index = ch - 'a';

            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return curr.eow == true;
    }

    public static boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';

            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return true;      //no need to check for eow to be true
    }
    public static void main(String[] args) {
        String words[] = {"apple", "app", "man", "mango", "woman"};

        for (String word : words) {
            insert(word);
        }

        String prefix1 = "app";
        String prefix2 = "monkey";

        System.out.println(startsWith(prefix1));
        System.out.println(startsWith(prefix2));
    }
}
