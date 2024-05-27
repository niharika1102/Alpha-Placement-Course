import java.util.*;

public class StringConversion {
    public static int operations(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        } 

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                char s1 = str1.charAt(i - 1);
                char s2 = str2.charAt(j - 1);

                if (s1 == s2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    int ans1 = dp[i][j - 1];
                    int ans2 = dp[i - 1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        int lcs = dp[n][m];
        int delete = n - lcs;
        int insert = m - lcs;

        return insert + delete;
    }
    public static void main(String[] args) {
        String word1 = "pear";
        String word2 = "sea";

        System.out.println(operations(word1, word2));
    }
}
