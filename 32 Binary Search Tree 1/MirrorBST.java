public class MirrorBST {
    static class Node {
        int data;
        Node left, right;

        public Node (int data) {
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

    public static Node mirror(Node root) {
        if (root == null) {     //Base case
            return null;
        }

        //Calculating left and right child of a node
        Node leftSubtree = mirror(root.left);
        Node rightSubtree = mirror(root.right);

        //Swapping left and right child
        root.left = rightSubtree;
        root.right = leftSubtree;

        return root;
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

        root = mirror(root);
        inorder(root);
    }
}
