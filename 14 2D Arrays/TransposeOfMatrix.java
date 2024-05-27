import java.util.*;

public class TransposeOfMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int arr[][] = new int[2][3];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("--------------------");

        int transposeArr[][] = new int[3][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                transposeArr[j][i] = arr[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(transposeArr[i][j] + " ");
            }
            System.out.println();
        }
        
        input.close();
    }
}
