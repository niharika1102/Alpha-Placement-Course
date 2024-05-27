import java.util.*;

public class NoOfSeven {
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

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 7) {
                    count++;
                }
            }
        }

        System.out.println(count);
        
        input.close();
    }
}
