import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int arr[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        //Bubble Sort
        for (int turn = 0; turn < n; turn++) {       //This loop is only to keep the track of turns
            for (int j = 0; j < n - 1 - turn; j++) {     //This loop is used to check the larger and/or smaller element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
        input.close();
    }
}
