import java.util.*;

public class MinArrayJumps {
    public static int minJumps(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n + 1];

        Arrays.fill(dp, -1);

        dp[n - 1] = 0;     //0 jumps are needed to go from last index to last index

        for (int i = n - 2; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;
            int steps = arr[i];

            for (int j = i + 1; j <= i + steps && j < n; j++) {
                if (dp[j] != -1) {
                    ans = Math.min(ans, dp[j] + 1);     //dp[j] + 1 means that we know the ways to reach from j to n - 1. We just add the current jump to it.
                }
            }

            if (ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int arr[] = {2,3,1,1,4};

        System.out.println(minJumps(arr));
    }
}
