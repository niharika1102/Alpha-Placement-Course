import java.util.*;

public class MCMRecursion {
    public static int mcm(int arr[], int i, int j) {
        if (i == j) {   //multiplication of single matrix is base case
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost1 = mcm(arr, i, k);   //set1
            int cost2 = mcm(arr, k + 1, j);   //set2
            int cost3 = arr[i - 1] * arr[k] * arr[j];     //cost of the two sets together
            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        System.out.println(mcm(arr, 1, arr.length - 1));
    }
}
