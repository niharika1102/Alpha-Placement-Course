import java.util.*;

public class GridWays {
    // public static int countWays(int i, int j, int n, int m) {
    //     //Base case
    //     if (i == n - 1 && j == m - 1) {    //Reached target cell
    //         return 1;
    //     }
    //     else if (i == n || j == m) {     //Crossing the grid on any boundary
    //         return 0;
    //     }

    //     int w1 = countWays(i + 1, j, n, m);    //Total down ways
    //     int w2 = countWays(i, j + 1, n, m);    //Total right ways
    //     return w1 + w2;
    // }

    public static int fact(int num) {
        int ans = 1;
        while (num >= 1) {
            ans = ans * num;
            num--;
        }

        return ans;
    }

    public static int permutations(int n, int m) {
        int ans = (fact(n + m - 2)) / (fact(n - 1) * fact(m - 1));
        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = 3, m = 3;
        // System.out.println(countWays(0, 0, n, n));

        System.out.println(permutations(n, m));
        
        input.close();
    }
}
