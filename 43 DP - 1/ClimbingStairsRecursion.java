import java.util.*;

public class ClimbingStairsRecursion {
    public static int waysRecursion (int n) {
        if (n == 0) {
            return 1;
        }
        else if (n < 0) {
            return 0;
        }

        return waysRecursion(n - 1) + waysRecursion(n - 2);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(waysRecursion(n));
    }
}
