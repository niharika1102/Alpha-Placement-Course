public class DeleteANode {
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

        if (root.data < val) {
            root.right = insert(root.right, val);
        }
        else {
            root.left = insert(root.left, val);
        }

        return root;
    }

    public static Node delete(Node root, int val) {
        //Searching for the node in the tree
        if (root.data < val) {          //The node lies in the right subtree so we make a call to delete in the right subtree
            root.right = delete(root.right, val);
        }

        else if (root.data > val) {       //Node lies in the left subtree
            root.left = delete(root.left, val);
        }

        //Node found, now deleting
        else {
            //Case 1 - Leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            //Case 2 - Single child
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            //Case 3 - Two children
            Node inorderSuccessor = findInorderSuccessor(root.right);      //Inorder successor always exists in the right subtree
            root.data = inorderSuccessor.data;      //Replacing data of the node with its inorder successor
            root.right = delete(root.right, inorderSuccessor.data);      //Deleting the inorder successor from the right subtree
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {      //We keep moving left till the time null value is not obtained
            root = root.left;
        }

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

        int key = 4;
        delete(root, key);

        inorder(root);
    }
}
