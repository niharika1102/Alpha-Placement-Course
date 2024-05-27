import java.util.*;;

public class MergeTwoBST {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> mergedAL, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(mergedAL.get(mid));

        root.left = createBST(mergedAL, start, mid - 1);
        root.right = createBST(mergedAL, mid + 1, end);

        return root;
    }

    public static Node mergeBST(Node root1, Node root2) {
        //Get inorder of BST1 and BST2
        ArrayList<Integer> inorder1 = new ArrayList<>();
        getInorder(root1, inorder1);

        ArrayList<Integer> inorder2 = new ArrayList<>();
        getInorder(root2, inorder2);

        //Merge sorted arrays
        int i = 0, j = 0;
        ArrayList<Integer> mergedAL = new ArrayList<>();
        while (i < inorder1.size() && j < inorder2.size()) {
            if (inorder1.get(i) <= inorder2.get(j)) {     //If element at inroder1 is less
                mergedAL.add(inorder1.get(i));
                i++;
            }
            else {      //If element at inorder2 is less
                mergedAL.add(inorder2.get(j));
                j++;
            }
        }

        //Adding leftover elements
        while (i < inorder1.size()) {
            mergedAL.add(inorder1.get(i));
            i++;
        }
        while (j < inorder2.size()) {
            mergedAL.add(inorder2.get(2));
            j++;
        }

        //Creating BST from sortd array
        return createBST(mergedAL, 0, mergedAL.size() - 1);
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
        //BST 1
        //      2
        //    /  \
        //   1    4

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        //BST 2
        //     9
        //   /  \
        //  3    12

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        //Expected final BST
        //          3
        //        /   \
        //       1     9
        //       \    / \
        //        2  4  12

        Node root = mergeBST(root1, root2);
        preorder(root);
    }
}
