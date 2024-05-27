public class ValidateBST {
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

        if(root.data > val) {
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static boolean isValid(Node root, Node min, Node max) {
        if (root == null) {     //An empty binary tree is always valid
            return true;
        }

        if (min != null && root.data <= min.data) {         //Value in the left subtree > root. This violates the condition of valid BST
            return false;
        }

        else if (max != null && root.data >= max.data) {     //Value in right sutree < root. This violates the condition of a valid BST 
            return false;
        }

        return isValid(root.left, min, root) && isValid(root.right, root, max);    //Checking for valid BST in left and right subtree
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
        // int values[] = {1,1,1};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        System.out.println(isValid(root, null, null));
    }    
}
