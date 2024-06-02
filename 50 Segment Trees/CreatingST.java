import java.util.*;

public class CreatingST {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static int buildST(int arr[], int i, int start, int end) {
        //Base case
        if (start == end) {
            tree[i] = arr[start];     //leaf nodes have been reached
            return arr[start];
        }

        int mid = (start + end) / 2;
        buildST(arr, 2 * i + 1, start, mid);   //left subtree
        buildST(arr, 2 * i + 2, mid + 1, end);   //right subtree

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];   //left child + right child = parent node value
        return tree[i];
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;

        init(n);

        buildST(arr, 0, 0, n - 1);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
    }
}
