public class BuildABST {
    static class Node {
        int data;
        Node left, right;

        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildBST(Node root, int val) {
        if (root == null) {      //If root is null, we create a new node and make it root node
            root = new Node(val);
            return root;
        }

        if (val < root.data) {
            //Insert in left subtree
            root.left = buildBST(root.left, val);
        }
        else {
            //Insert in right subtree
            root.right = buildBST(root.right, val);
        }

        return root;
    }

    //In order traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        // for (int i = 0; i < values.length; i++) {
        //     root = buildBST(root, values[i]);
        // }

        for (int i = 1; i < 11; i++) {
            root = buildBST(root, i);
        }

        inorder(root);
    }
}