// package 18 Recursion;
import java.util.*;

public class PrintFactorial {
    public static int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int ans = fact(n);
        System.out.println(ans);
        
        input.close();
    }
}
