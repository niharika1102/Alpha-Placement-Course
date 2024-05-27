// package 12 Arrays;

import java.util.*;

public class ReverseAnArray {

    public static void reverse(int arr[]) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        int size = input.nextInt();
        int arr[] = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        reverse(arr);

        input.close();
    }
}
