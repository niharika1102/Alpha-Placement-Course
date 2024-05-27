// package 14 2D Arrays;

import java.util.*;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int matrix[][] = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        int n = matrix.length;
        int m = matrix[0].length;

        //Spiral printing
        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = m - 1;

        while (startRow <= endRow && startCol <= endCol) {
            
            //Top
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(matrix[startRow][i] + " ");
            }

            //Right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            //Bottom
            for (int i = endCol - 1; i >= startCol; i--) {
                if (startRow == endRow) {    //If middle element is left out, it will be printed in the top condition, to avoin printing it again, we use this condition
                    break;
                }
                System.out.print(matrix[endRow][i] + " ");
            }

            //Left
            for (int i = endRow - 1; i > startRow; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }
            
            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
        
        input.close();
    }
}
