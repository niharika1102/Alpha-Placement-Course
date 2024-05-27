import java.util.*;

public class FloodFillAlgorithm {
    public static int[][] floodFill(int image[][], int sr, int sc, int colour) {
        //Visited matrix
        boolean visited[][] = new boolean[image.length][image[0].length];

        floodFillUtil(image, sr, sc, colour, visited, image[sr][sc]);
        return image;
    }

    public static void floodFillUtil(int image[][], int sr, int sc, int colour, boolean visited[][], int oriColour) {
        //Base case
        //Case 1: invalid image cell
        //Case 2: already visited cell (will lead to cycle)
        //Case 3: Not the original colour
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visited[sr][sc] == true || image[sr][sc] != oriColour) {
            return;
        }

        //Calling for left, right, up and down positions recursively
        //left
        floodFillUtil(image, sr, sc - 1, colour, visited, oriColour);

        //right
        floodFillUtil(image, sr, sc + 1, colour, visited, oriColour);

        //up
        floodFillUtil(image, sr - 1, sc, colour, visited, oriColour);

        //down
        floodFillUtil(image, sr + 1, sc, colour, visited, oriColour);
    }

    public static void main(String[] args) {
        int image[][] = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int colour = 2;

        System.out.println(floodFill(image, sr, sc, colour));
    }
}
