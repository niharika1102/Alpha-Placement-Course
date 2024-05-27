public class TransformToSumTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int transform(Node root) {
        if (root == null) {           //If the node is null, 0 is returned to its parent to calculate sum
            return 0;
        }

        //Finding the left and right child of the node to add to the node sum
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        //Storing data of the current node to return to the parent
        int data = root.data;

        //We get the value of left and right child of root only when it is not null
        int newLeft = 0;
        if (root.left != null) {
            newLeft = root.left.data;
        }

        int newRight = 0;
        if (root.right != null) {
            newRight = root.right.data;
        }

        //Changing the data of the root to the sum of leftChild, rightChild, value @leftSubtree and value @rightSubtree
        root.data = newLeft + leftChild + newRight + rightChild;

        return data;     //Returning data of current node to its parent
    }

    //Preorder traversal
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
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

        //Expected Tree

        //         27
        //       /   \
        //      9     13
        //    /  \   /  \
        //   0   0  0   0

        transform(root);
        preOrder(root);
    }    
}
