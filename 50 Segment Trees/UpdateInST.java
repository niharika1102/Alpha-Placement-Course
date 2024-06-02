import java.util.*;

public class UpdateInST {
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

    public static int getSumUtil(int i, int Si, int Sj, int qi, int qj) {
        //Non-overlap
        if (qj <= Si || qi >= Sj) {
            return 0;
        }

        //Complete overlap
        else if (Si >= qi && Sj <= qj) {
            return tree[i];
        }

        //Partial overlap
        else {
            int mid = (Si + Sj) / 2;
            int left = getSumUtil(2 * i + 1, Si, mid, qi, qj);
            int right = getSumUtil(2 * i + 2, mid + 1, Sj, qi, qj);
            return left + right;
        }
    }

    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    public static void update(int arr[], int index, int newVal) {
        int diff = newVal - arr[index];
        arr[index] = newVal;
        int n = arr.length;

        updateUtil(0, 0, n - 1, index, diff);
    }

    public static void updateUtil(int i, int Si, int Sj, int index, int diff) {
        if (index < Si || index > Sj) {      //not in range
            return;
        }

        tree[i] += diff;    //for leaf nodes
        if (Si != Sj) {
            int mid = (Si + Sj) / 2;
            updateUtil(2 * i + 1, Si, mid, index, diff);    //left
            updateUtil(2 * i + 2, mid + 1, Sj, index, diff);   //right
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;

        init(n);

        buildST(arr, 0, 0, n - 1);

        System.out.println(getSum(arr, 2, 5));
        update(arr, 2, 2);
        System.out.println(getSum(arr, 2, 5));
    }
}
