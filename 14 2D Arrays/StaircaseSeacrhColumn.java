import java.util.*;

public class StaircaseSeacrhColumn {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int matrix[][] = {
            {10,20,30,40},
            {15,25,35,45},
            {27,29,37,48},
            {32,33,39,50}
        };

        int key = 33;

        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == key) {
                System.out.println("Found at matrix[" + row + "][" + col + "]");
                break;
            }

            else if (key > matrix[row][col]) {
                col++;
            }

            else {
                row--;
            }
        }

        input.close();
    }
}
