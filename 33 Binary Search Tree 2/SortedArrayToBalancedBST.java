public class SortedArrayToBalancedBST {
    static class Node {
        int data;
        Node left, right;

        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node createBST(int arr[], int start, int end) {
        if (start > end) {    //If the start goes beyond end, this means that the elements to be added have ended. So, print null.
            return null;
        }

        int mid = (start + end) / 2;      //Finding mid index of array
        Node root = new Node(arr[mid]);     //Alloting root to arr[mid] element

        root.left = createBST(arr, start, mid - 1);     //Creating left subtree
        root.right = createBST(arr, mid + 1, end);      //Creating right subtree
        return root;
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
        int arr[] = {3,5,6,8,10,11,12};

        //Tree to obtain
        //          8
        //        /  \
        //      5     11
        //     / \    / \
        //    3  6   10 12

        Node root = createBST(arr, 0, arr.length - 1);
        preorder(root);
    }
}
