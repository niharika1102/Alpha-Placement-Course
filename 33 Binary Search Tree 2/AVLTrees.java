public class AVLTrees {
    static class Node {      //Height of each node is also stored in the Node class.
        int data, height;
        Node left, right;

        public Node (int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root) {
        if (root == null) {   //Height of leaf is 0
            return 0;
        }

        return root.height;
    }

    public static int getBalance(Node root) {     //Calculating balance factor
        if (root == null) {
            return 0;
        }

        return height(root.left) - height(root.right);
    }

    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        //Rotate
        y.left = x;
        x.right = T2;

        //Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;    //y is the new root
    }

    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        //Rotate
        x.right = y;
        y.left = T2;

        //Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;    //x is the new root
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        else if (key > root.data) {
            root.right = insert(root.right, key);
        }
        else {  //In case of duplicate nodes
            return root;
        }

        //Update height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        int balanceFactor = getBalance(root);

        //Rotations
        //LL case
        if (balanceFactor > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        //RR case
        if (balanceFactor < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        //LR case
        if (balanceFactor > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //RL case
        if (balanceFactor < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;     //AVL tress is balanced
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        //Expected Tree
        //          30
        //         /  \
        //        20  40
        //       /  \  \
        //      10  25  50

        preorder(root);
    }
}