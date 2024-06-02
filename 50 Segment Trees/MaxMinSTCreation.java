import java.util.*;

public class MaxMinSTCreation {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void buildST(int arr[], int i, int Si, int Sj) {
        if (Si == Sj) {     //leaf node: base case
            tree[i] = arr[Si];
            return;
        }

        int mid = (Si + Sj) / 2;

        buildST(arr, 2 * i + 1, Si, mid);
        buildST(arr, 2 * i + 2, mid + 1, Sj);

        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static void main(String[] args) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;

        init(n);
        buildST(arr, 0, 0, n - 1);

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
    }
}
