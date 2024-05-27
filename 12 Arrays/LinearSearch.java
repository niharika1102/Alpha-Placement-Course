// package 12 Arrays;

import java.util.*;

public class LinearSearch {

    public static void search(int size, int arr[], int key) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                System.out.println("Found at: " + i);
            }
            else {
                System.out.println("Not found");
                break;
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

        int key = input.nextInt();

        search(size, arr, key);

        input.close();
    }
}
