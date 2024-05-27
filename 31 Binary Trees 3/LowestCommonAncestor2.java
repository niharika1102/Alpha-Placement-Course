public class LowestCommonAncestor2 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right=  null;
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

        System.out.println(lca(root, n1, n2).data);
    }
}
