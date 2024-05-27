// package 19 Divide and Conquer;
import java.util.*;

public class SortedAndRotatedArray {

    public static int findTarget(int arr[], int target, int start, int end) {
        int mid = (start + (end - start)) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[start] <= arr[mid]) {
            if (arr[start] <= target && target <= arr[mid]) {
                return findTarget(arr, target, start, mid - 1);
            }
            else {
                return findTarget(arr, target, mid + 1, end);
            }
        }

        else {    
            if (arr[mid] <= target && target <= arr[end]) {
                return findTarget(arr, target, mid + 1, end);
            }
            else {
                return findTarget(arr, target, start, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int size = input.nextInt();
        int arr[] = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        int target = input.nextInt();

        int found = findTarget(arr, target, 0, arr.length - 1);
        System.out.println(found);
        
        input.close();
    }
}
