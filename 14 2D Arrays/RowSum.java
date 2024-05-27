import java.util.*;

public class RowSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int rows = input.nextInt();
        int cols = input.nextInt();

        int matrix[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        int rowNo = input.nextInt();

        int sum = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            sum = sum + matrix[rowNo - 1][i];
        }

        System.out.println(sum);
        
        input.close();
    }
}
