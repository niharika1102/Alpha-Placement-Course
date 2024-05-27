import java.util.*;

public class HeightOfTree {
    static class Node {
        int data;
        Node left, right;

        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {      //In terms of nodes height is calculated
        if (root == null) {    //Base case - no node exists (i.e., in child of leaf node)
            return 0;
        }

        int leftH = height(root.left);     //Height of left subtree
        int rightH = height(root.right);    //Height of right subtree

        return Math.max(leftH, rightH) + 1;    //Parent is one level above the child, so +1.
    }

    public static void main(String[] args) {
        //         1
        //      /     \          
        //     2       3
        //   /  \     /  \
        // 4     5   6    7

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int res = height(root) - 1;

        System.out.println("In terms of nodes, height is: " + height(root));
        System.out.println("In terms of edges, height is: " + res);
    }       
}
