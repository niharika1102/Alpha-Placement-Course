import java.util.*;

public class LongestCommonSubstring {
    public static int substringLength(String str1, String str2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];
        int ans = 0;

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
 
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                char s1 = str1.charAt(i - 1);
                char s2 = str2.charAt(j - 1);

                if (s1 == s2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";
        int n = str1.length();
        int m = str2.length();

        System.out.println(substringLength(str1, str2, n, m));
    }
}
