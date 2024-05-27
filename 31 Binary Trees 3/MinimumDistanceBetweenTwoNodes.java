public class MinimumDistanceBetweenTwoNodes {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node lca(Node root, int n1, int n2) {
        //Base case
        if (root == null) {
            return null;
        }

        //Checking if root is n1 or n2. This would mean that LCA would be root
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        //Checking for LCA in right or left subtree
        Node leftLCA = lca(root.left, n1, n2);
        Node rightLCA = lca(root.right, n1, n2);

        //If value of LCA is found in leftSubtree but the rightLCA returns false. This means that both n1 and n2 are in the leftSubtree. So, leftLCA is the final answer
        if(rightLCA == null) {
            return leftLCA;
        }
        if (leftLCA == null) {
            return rightLCA;
        }

        //Now, if both leftLCA and rightLCA return a valid answer, in that case, root will be the lca.
        return root;
    }

    public static int lcaDist(Node root, int n) {
        if (root == null) {        //Base case
            return -1;
        }

        if (root.data == n) {        //Element found at current position in tree
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        else if (leftDist == -1) {
            return rightDist + 1;
        }
        else {
            return leftDist + 1;
        }
    }

    public static int minDistance(Node root, int n1, int n2) {
        Node lca = lca(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
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

        int n1 = 4;
        int n2 = 7;

        System.out.println(minDistance(root, n1, n2));
    }
}
