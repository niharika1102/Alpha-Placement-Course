import java.util.*;

public class MCMMemoization {
    public static int mcm(int arr[], int i, int j, int dp[][]) {
        if (i == j) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm(arr, i, k, dp);
            int cost2 = mcm(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }

        return dp[i][j] = ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        int n = arr.length;
        int dp[][] = new int[n][n];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int i = 1;
        int j = n - 1;

        System.out.println(mcm(arr, i, j, dp));
    }
}
