import java.util.*;

public class NQueens {

    public static boolean isSafe(char board[][], int row, int col) {
        //Vertical up   //The column doesn't change only row = row - 1 for the previous cell vertically up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //Diagonal left up    //Both the row and col value decrease by one as we move to the previous diagonal cell
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //Diagonal right up    //Row decreases value and columen increases value as we move up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // public static void queens(char board[][], int row) {    //row is the row from which we start placing the queens 
    //     //Base case
    //     if (row == board.length) {
    //         //To print all possible solutions
    //         // printBoard(board);
    //         // System.out.println();

    //         //to count total number of ways
    //         count++;
    //         return;
    //     }

    //     //Recursion
    //     for (int j = 0; j < board.length; j++) {
    //         //Check safe position
    //         if (isSafe(board, row, j)) {
    //             board[row][j] = 'Q';
    //             queens(board, row + 1);    //To place the queen in the next row
    //             board[row][j] = '-';    //Backtracking to remove the queen from that position
    //         }
    //     }
    // }


    //Print anyone solution
    public static boolean OneQueens(char board[][], int row) {
        //Base case
        if (row == board.length) {   //last row
            //To print all possible solutions
            // printBoard(board);
            // System.out.println();

            //to count total number of ways
            count++;
            return true;
        }

        //Recursion
        for (int j = 0; j < board.length; j++) {
            //Check safe position
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if(OneQueens(board, row + 1)) {
                    return true;
                }
                board[row][j] = '-';    //Backtracking to remove the queen from that position
            }
        }

        return false;
    }

    public static void printBoard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = 2;
        char board[][] = new char[n][n];

        //Initializing the chess board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '-';
            }
        }

        // queens(board, 0);  
        // System.out.println("Total ways to solve " + n + "-Queens problem: " + count);   
        
        //Anyone solution
        if (OneQueens(board, 0)) {
            System.out.println("Solution exists");
            printBoard(board);
        }
        else {
            System.out.println("No possible solution");
        }
        
        input.close();
    }
}