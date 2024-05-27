import java.util.*;

public class TargetSumTabulation {
    public static boolean isTarget(int nums[], int target) {
        int n = nums.length;
        boolean dp[][] = new boolean[n + 1][target + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;     //If sum is 0, the result is always achieveable by not adding any numbers.
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                int v = nums[i - 1];

                //valid and include
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                }

                //exclude
                if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int nums[] = {4,2,7,1,3};
        int target = 1000;

        System.out.println(isTarget(nums, target));
    }
}
