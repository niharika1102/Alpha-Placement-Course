// package 18 Recursion;
import java.util.*;

public class PrintFrom1Ton {

    public static void PrintInc(int n) {
        if (n == 1) {
            System.out.print(1 + " ");
            return;
        }

        PrintInc(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        PrintInc(n);

        input.close();
    }
}
