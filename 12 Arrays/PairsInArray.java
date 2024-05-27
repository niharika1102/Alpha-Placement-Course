import java.util.*;

public class PairsInArray {
    
    public static void pairs(int arr[], int size) {
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                System.out.print("(" + arr[i] + ", " + arr[j] + ")");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int arr[] = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        pairs(arr, size);

        input.close();
    }
}