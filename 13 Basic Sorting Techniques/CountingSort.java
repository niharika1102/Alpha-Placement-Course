import java.util.*;

public class CountingSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int arr[] = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        //Counting Sort

        //Make count array
        int max = arr[0];

        for (int i = 1; i < size; i++) {
            max = Math.max(arr[i], max);
        }

        int count[] = new int[max + 1];
        for (int i = 0; i < max; i++) {
            count[arr[i]]++;
        }

        for (int i = 0; i < max; i++) {
            System.out.println(count[i]);
        }
        
        input.close();
    }
}
