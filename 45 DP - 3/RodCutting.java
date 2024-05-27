import java.util.*;

public class RodCutting {
    public static int maxProfit(int lengths[], int price[], int rodLength) {
        int dp[][] = new int[lengths.length + 1][rodLength + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < lengths.length + 1; i++) {
            for (int j = 1; j < rodLength + 1; j++) {
                int v = price[i - 1];
                int l = lengths[i - 1];

                if (l <= j) {    //generates a valid answer
                    int profit1 = v + dp[i][j - l];
                    int profit2 = dp[i - 1][j];

                    dp[i][j] = Math.max(profit1, profit2);
                }
                else {     //invalid answer case
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[lengths.length][rodLength];
    }
    public static void main(String[] args) {
        int lengths[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int rodLength = 8;

        System.out.println(maxProfit(lengths, price, rodLength));
    }
}
