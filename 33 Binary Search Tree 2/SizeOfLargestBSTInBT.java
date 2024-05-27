public class SizeOfLargestBSTInBT {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {    //To obtain info of each node
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int maxBST = 0;     //To store the size of the largest BST

    public static Info largestBST(Node root) {
        //Base case - If root == null, it is the largest BST with size 0, max = -infintiy, min = +infinity
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        //Calculating the left and right subtree info
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        //Calculating self info from left and right info
        //1. Calculating size
        int size = leftInfo.size + rightInfo.size + 1;

        //2. Min
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));

        //3. Max
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        //4. isBST
        //Checking if current node is a vaid BST
        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {    //Not a valid BST
            return new Info(false, size, min, max);
        }

        //Checking if left and right subtree are valid BST
        if (leftInfo.isBST == true && rightInfo.isBST == true) {
            //If BST is valid, update maxBST value
            maxBST = Math.max(size, maxBST);
            return new Info(true, size, min, max);
        }

        //In all other cases, we return false
        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {
        //Tree
        //          50
        //         /  \
        //       30    60
        //      / \    / \
        //     5  20  45  70
        //               /  \
        //              65  80

        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        Info info = largestBST(root);
        System.out.println(maxBST);
    }
}
