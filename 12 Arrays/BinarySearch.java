// package 12 Arrays;

import java.util.*;

public class BinarySearch {

    public static void binarySearch(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;

        int found = 0;

        for (int i = 0; i < arr.length; i++) {
            int mid = ((start + end) / 2);
            if (arr[mid] == key) {
                found = mid;
                break;
            }
            else if (arr[mid] < key) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        System.out.println("Found at: " + found);

        // if (start > end) {
        //     System.out.println("Not found");
        // }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int arr[] = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        int key = input.nextInt();

        binarySearch(arr, key);

        input.close();
    }
}