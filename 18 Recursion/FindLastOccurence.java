import java.util.Scanner;

public class FindLastOccurence {

    public static int lastOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }

        int isFound = lastOccurence(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }

        return isFound;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int size = input.nextInt();
        int arr[] = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        int key = input.nextInt();

        int res = lastOccurence(arr, key, 0);
        System.out.println(res);
        
        input.close();
    }
}
