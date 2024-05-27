import java.util.*;

public class ClimbingStairsTabulation {
    public static int countWays(int n) {
        int dp[] = new int[n + 1];    //initialize
        dp[0] = 1;      //base case

        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            }
            else {
                dp[i] = dp[i - 1] + dp[i - 2];    //dp core step
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countWays(n));
    }
}
