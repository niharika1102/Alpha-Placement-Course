import java.util.*;

public class CoinChange {
    public static int countWays(int coins[], int sum) {
        int dp[][] = new int[coins.length + 1][sum + 1];

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i < dp.length; i++) {     //there is one way to make sum 0, by giving no change to anyone
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = coins[i - 1];

                if (v <= j) {    //valid answer case    //i = no. of coins, j = sum
                    int ans1 = dp[i][j - v];     //include
                    int ans2 = dp[i - 1][j];      //exclude
                    dp[i][j] = ans1 + ans2;
                }
                else {     //invalid answer case
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length][sum];
    }

    public static void main(String[] args) {
        int coins[] = {1,2,5};
        int sum = 11;

        System.out.println(countWays(coins, sum));
    }
}
