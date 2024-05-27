public class DiameterOfTree1 {
    static class Node {
        int data;
        Node left, right;

        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if (root == null) {      //Base case of leaf nodes
            return 0;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);
        return Math.max(leftH, rightH) + 1;
    }

    public static int diameter(Node root) {
        if (root == null) {       //Base case of leaf nodes
            return 0;
        }

        //Calculating left and right subtree heights for a node
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        //Calculating left and right diameters for a node
        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);

        //Calculating diamater that passes thro the current node
        int selfDia = leftHeight + rightHeight + 1;

        //Returning final diameter - max out of the three calculated
        return Math.max(rightDia, Math.max(selfDia, leftDia));         //IMP: Math.max works only for two values. So, we calculate it twice
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

        System.out.println(diameter(root));
    }
}
