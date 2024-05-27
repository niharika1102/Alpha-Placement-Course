public class PrintInRange {
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

    public static void RangePrint(int k1, int k2, Node root) {
        if (root == null) {     //If roor is null, backtrack
            return;
        }

        if (k1 <= root.data && root.data <= k2) {     //If root lies between k1 and k2, call for left subtree, print root and call for right subtree
            RangePrint(k1, k2, root.left);
            System.out.print(root.data + " ");
            RangePrint(k1, k2, root.right);
        }
        else if (root.data < k1) {       //If root < k1, traverse the left subtree
            RangePrint(k1, k2, root.left);
        }
        else {     //In all other cases, traverse right subtree
            RangePrint(k1, k2, root.right);
        }
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
        RangePrint(5, 12, root);
    }    
}