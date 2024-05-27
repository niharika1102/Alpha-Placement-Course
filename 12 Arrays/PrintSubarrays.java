import java.util.*;

public class PrintSubarrays {

    public static void subarrays(int arr[], int size) {
        for (int i = 0; i < size; i++) {     //iterates over the starting index of the subarray
            for (int j = i; j < size; j++) {    //iterates over the ending index of the subarray
                for (int k = i; k <= j; k++) {    //iterates over each element of the subarray
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int arr[] = new int[size];

        for (int i = 0; i < size; i++ ) {
            arr[i] = input.nextInt();
        }

        subarrays(arr, size);

        input.close();
    }
}
