// package 18 Recursion;.
import java.util.*;

public class checkSortedArray {
    public static void checkSorted(int n, int[] arr) {
        if (n == 1) {
            System.out.println("Yes");
            return;
        }

        else {
            if (arr[n - 1] > arr[n]) {
                System.out.println("No");
                return;
            }
            checkSorted(n - 1, arr);
        }
    }    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        checkSorted(n - 1, arr);

        input.close();
    }
}
