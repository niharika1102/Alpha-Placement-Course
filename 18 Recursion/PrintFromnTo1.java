// package 18 Recursion;
import java.util.*;

public class PrintFromnTo1 {

    public static void Printing(int n) {
        //base case
        if (n == 1) {
            System.out.print(1);
            return;
        }
        
        System.out.print(n + " ");
        Printing(n - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        Printing(n);
        
        input.close();
    }
}
