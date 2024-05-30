import java.util.*;

public class MinimumPartitioning {

    public static int minDiff(int arr[]) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int capacity = sum / 2;

        int dp[][] = new int[n + 1][capacity + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //number yielding a valid ans
                if (arr[i - 1] <= j) {
                    //include
                    int ans1 = arr[i - 1] + dp[i - 1][j - arr[i - 1]];    //include
                    int ans2 = dp[i - 1][j];   //exclude
                    dp[i][j] = Math.max(ans1, ans2);
                }

                //number yielding invalid ans
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int sum1 = dp[n][capacity];
        int sum2 = sum - sum1;

        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {
        int arr[] = {1,6,11,5};

        System.out.println(minDiff(arr));
    }
}
