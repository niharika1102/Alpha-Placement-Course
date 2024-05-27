// package 21 Backtracking;
import java.util.*;

public class BacktrackOnArray {

    public static void changeArr(int arr[], int i, int val) {     //i is the index to traverse the array and val is the value to be stored at the current index
        //Base case
        if (i == arr.length) {
            printArr(arr);
            return;
        }

        //Recursion
        arr[i] = val;
        changeArr(arr, i + 1, val + 1);     //To increase the value stored at the other indices
        //When we reach the last index of the array, we have to start decreasing the value at each index of the array by 2 coming backward in the array.
        arr[i] = arr[i] - 2;
    }
    
    //To print the array
    public static void printArr(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);

        input.close();
    }
}
