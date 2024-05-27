import java.util.*;

public class ClimbingStairsVariation {
    public static int countWays(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }
        else if (n < 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        // else if (n == 2) {
        //     return 2;
        // }

        if (ways[n] != -1) {
            return ways[n];
        }

        ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways) + countWays(n - 3, ways);
        return ways[n];
    }
    public static void main(String[] args) {
        int n = 5;
        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);

        System.out.println(countWays(n, ways));
    }
}
