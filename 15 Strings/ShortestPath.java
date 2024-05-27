// package 15 Strings;
import java.util.*;

public class ShortestPath {

    public static int pathValue(String str) {

        int x = 0, y = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'N') {
                y++;
            }
            else if (ch == 'S') {
                y--;
            }
            else if (ch == 'E') {
                x++;
            }
            else if (ch == 'W') {
                x--;
            }
        }

        int dist = ((x * x) + (y * y));
        int distFinal = (int) Math.pow(dist, 0.5);

        return distFinal;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String str = input.nextLine();

        int res = pathValue(str);
        System.out.println(res);
        
        input.close();
    }
}
