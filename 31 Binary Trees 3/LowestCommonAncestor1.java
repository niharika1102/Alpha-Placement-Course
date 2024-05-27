import java.util.*;

public class LowestCommonAncestor1 {
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

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        //Base case
        if (root == null) {
            return false;
        }

        //Adding the root initally to the path. 
        path.add(root);

        //If root's data == n, means node is found, so we return true.
        if (root.data == n) {
            return true;
        }

        //Else, we search for the node in left and right subtree of root
        boolean leftFound = getPath(root.left, n, path);
        boolean rightFound = getPath(root.right, n, path);

        //If node is found in either of left or right subtree, method return true
        if (leftFound || rightFound) {
            return true;
        }

        //Else, the last node added to the path will not be a part of the path. So, we remove it and return false.
        path.remove(path.size() - 1);
        return false;
    }

    public static void lca(Node root, int n1, int n2) {
        //Step 1: Finding path for n1 and n2
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        //Step 2: Traversing path to find last common ancestor
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            //We check for the unequal case i.e., if the ith value of path1 and path2 is not equal, this means that we have reached a point where they won't be equal anywhere in future
            //So, we break from the loop
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        //Since, we break from the loop at the position where values of path1 and path2 are not equal at i. 
        //So, this means that value at i - 1 is equal. So, that is the final answer.
        Node lca = path1.get(i - 1);
        System.out.println(lca.data);
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
        int n2 = 2;

        lca(root, n1, n2);
    }
}
