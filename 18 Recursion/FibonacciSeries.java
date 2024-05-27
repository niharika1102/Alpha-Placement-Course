// package 18 Recursion;
import java.util.*;

public class FibonacciSeries {
    public static int Fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return Fibo(n - 1) + Fibo(n - 2);

        // return 1 + Fibo(n - 1) + Fibo(n - 2);             //Sum of fibonacci series
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int ans = Fibo(n);
        System.out.println(ans);
        
        input.close();
    }
}
