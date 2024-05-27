public class SearchInBST {
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

        if (root.data > val) {
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static boolean isFound(Node root, int key) {
        if (root == null) {    //Node not found and it does not exist in the tree
            return false;
        }

        if (root.data == key) {     //Value found
            return true;
        }

        if (root.data > key) {      //Key is smaller than root, so, it will be lying in the left subtree
            return isFound(root.left, key);
        }
        else {    //Key is smaller than root, so, it will be lying in the right subtree
            return isFound(root.right, key);
        }
    }
    
    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        int key = 0;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        System.out.println(isFound(root, key));
    }
}
