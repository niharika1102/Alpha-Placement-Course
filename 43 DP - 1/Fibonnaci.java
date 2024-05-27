import java.util.*;

public class Fibonnaci {
    public static int fibo1(int n, int dp1[]) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp1[n] != 0) {     //Result is already stored at the nth index of array
            return dp1[n];
        }

        dp1[n] = fibo1(n - 1, dp1) + fibo1(n - 2, dp1);
        return dp1[n];
    }

    public static int fibo2(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int dp1[] = new int[n + 1];

        System.out.println(fibo1(n, dp1));
        System.out.println(fibo2(n));
    }
}
