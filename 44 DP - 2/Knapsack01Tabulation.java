import java.util.*;

public class Knapsack01Tabulation {
    public static int knapsack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[val.length + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {     //first column of dp table has value 0
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {   //first row of dp table has value 0
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                //value and weight of the items to be included or excluded i.e. current item
                int v = val[i - 1];
                int w = wt[i - 1];

                if (w <= j) {    //valid answer possible
                    //include
                    int profit1 = v + dp[i - 1][j - w];     //item included and we check for the other item and the wieght of the knapsack is also reduced now. The weight is taken as j and not W because we are checking for all j weights till W.

                    //exclude
                    int profit2 = dp[i - 1][j];
                    dp[i][j] = Math.max(profit1, profit2);
                }
                else {     //invalid answer
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        System.out.println(knapsack(val, wt, W));
    }
}
