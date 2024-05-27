import java.util.*;

public class SubarraySum {
    public static void sum(int arr[], int size) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum = currSum + arr[k];
                }

                System.out.println(currSum);

                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }

        System.out.println();
        System.out.println(maxSum);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int size = input.nextInt();
        int arr[] = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        sum(arr, size);
        
        input.close();
    }
}