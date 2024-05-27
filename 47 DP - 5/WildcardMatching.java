import java.util.*;

public class WildcardMatching {
    public static boolean isMatch(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();

        boolean dp[][] = new boolean[n + 1][m + 1];

        dp[0][0] = true;      //if the pattern and string are empty, they will match

        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;    //if pattern is empty and string is not, then they will never match, so false
        }

        for (int j = 1; j < m + 1; j++) {
            if (pattern.charAt(j - 1) == '*') {    //in case if the char in pattern is *, value at dp array == dp[0][j - 1]
                dp[0][j] = dp[0][j - 1];
            } 
        }

        //filling up the array
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //Case 1: last char is same
                //Case 2: Last char of pattern is ?
                if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];    //we check for the previous cell of the matrix 
                }

                //Case 3: Last char of pattern is *
                else if (pattern.charAt(j - 1) == '*') {
                    //We can ignore the star or keep it
                    // boolean ans1 = dp[i][j - 1];    //remove the star from char
                    // boolean ans2 = dp[i - 1][j];    //check the star for the string after removing its last character

                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }

                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str = "baaabab";
        String pattern = "*****ba*****ab";

        System.out.println(isMatch(str, pattern));
    }
}
