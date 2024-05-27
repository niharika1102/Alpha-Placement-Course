import java.util.*;

public class ClimbingStairsMemoization {
    public static int waysMemoization (int n, int dp[]) {
        if (n == 0) {
            return 1;
        }
        else if (n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = waysMemoization(n - 1, dp) + waysMemoization(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(waysMemoization(n, dp));
    }
}
