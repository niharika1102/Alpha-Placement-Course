// package 18 Recursion;

import java.util.*;

public class FindFirstOccurence {
    public static void search(int[] arr, int i, int key) {
        if (arr[i] == key) {
            System.out.println(i);
            return;
        }

        if (i == arr.length) {
            System.out.println("-1");
            return;
        }

        search(arr, i + 1, key);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int size = input.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        int key = input.nextInt();

        search(arr, 0, key);

        input.close();
    }
}
