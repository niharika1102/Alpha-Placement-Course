import java.util.*;

public class RootToLeafPath {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data < val){
            root.right = insert(root.right, val);
        }
        else {
            root.left = insert(root.left, val);
        }

        return root;
    }

    public static void PrintPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }

        System.out.println();
    }

    public static void rootToLeaf(Node root, ArrayList<Integer> path) {
        if (root == null) {    //Base case
            return;
        }

        path.add(root.data);      //Adding root node to the path array list

        if (root.left == null && root.right == null) {      //If it is leaf node, we print the arraylist
            PrintPath(path);
        }
        
        //Making call to left and right subtree
        rootToLeaf(root.left, path);
        rootToLeaf(root.right, path);

        //Removing root value. We assume that the left and right subtree elements have been already removed from the path arraylist.
        //So, we remove only the root, i.ee the element at the last index
        path.remove(path.size() - 1);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        ArrayList<Integer> path = new ArrayList<>();
        rootToLeaf(root, path);
    }    
}
