import java.util.*;

public class CatalanRecursion {
    public static int Catalan(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            ans += Catalan(i) + Catalan(n - i - 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Catalan(n));
    }
}
