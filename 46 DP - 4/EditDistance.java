import java.util.*;

public class EditDistance {
    public static int operations(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                char c1 = str1.charAt(i - 1);
                char c2 = str2.charAt(j - 1);

                if (c1 == c2) {    //characters are same in both strings
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    int ans1 = dp[i - 1][j];    //Remove operation
                    int ans2 = dp[i][j - 1];     //Add operation
                    int ans3 = dp[i - 1][j - 1];   //Replace operation

                    dp[i][j] = Math.min(ans3, Math.min(ans1, ans2)) + 1;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";

        System.out.println(operations(word1, word2));
    }
}
