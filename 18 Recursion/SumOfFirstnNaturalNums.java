// package 18 Recursion;
import java.util.*;

public class SumOfFirstnNaturalNums {

    public static int Sum(int n) {
        if (n == 1) {
            return 1;
        }

        return n + Sum(n - 1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int ans = Sum(n);
        System.out.println(ans);

        input.close();
    }
}
