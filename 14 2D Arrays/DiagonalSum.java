// package 14 2D Arrays;

import java.util.*;

public class DiagonalSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int size = input.nextInt();
        int arr[][] = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = input.nextInt();
            }
        }

        int primarySum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == j) {
                    primarySum = primarySum + arr[i][j];
                }
            }
        }

        int secondarySum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i + j == size - 1) {
                    if (i == j) {
                        continue;
                    }
                    secondarySum = secondarySum + arr[i][j];
                }
            }
        }

        int total = primarySum + secondarySum;

        System.out.println(total);
        
        input.close();
    }
}
