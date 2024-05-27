import java.util.*;

public class CatalanTabulation {
    public static int Catalan(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;   //Base case
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 2;
        System.out.println(Catalan(n));
    }
}
