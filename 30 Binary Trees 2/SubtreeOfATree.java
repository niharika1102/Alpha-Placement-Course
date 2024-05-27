public class SubtreeOfATree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Step 1 -> Searching for the root of subtree in the main tree
    public static boolean isSubtree(Node root, Node subRoot) {  
        //Base case
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {     //Step 2
                return true;
            }
        }

        boolean leftAns = isSubtree(root.left, subRoot);   //present in left subtree
        boolean rightAns = isSubtree(root.right, subRoot);  //present in right subtree

        return leftAns || rightAns;     //If either case is true, print true
    }

    //Step 2 -> Checking for identical left and right child
    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {      //In case if both node and subRoot are null, this means that the isIdentical condition is true
            return true;
        } 
        else if (node == null || subRoot == null || node.data != subRoot.data) {      //Checks for the root node
            return false;
        }

        //Checks non identical for left subtree
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }

        //Checks non identical for right subtree
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        //If all checks pass, return true
        return true;
    }

    public static void main(String[] args) {
        //Main tree

        //         1
        //       /   \
        //      2     3
        //    /  \   /  \
        //   4    5  6   7

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //Subtree

        //         2
        //       /   \
        //      4     5
        
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        boolean res = isSubtree(root, subRoot);
        System.out.println(res);
    }
}