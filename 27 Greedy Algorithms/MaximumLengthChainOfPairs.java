import java.util.*;

public class MaximumLengthChainOfPairs {
    public static int maxChain(int pairs[][]) {
        int count = 0;

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));    //Sorting as per column 1 of the array

        count = 1;     //First pair selected
        int lastEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastEnd) {
                count++;
                lastEnd = pairs[i][1];
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int pairs[][] = {
            {5,24},
            {39,60},
            {5,28},
            {27,40},
            {50, 90}            
        };

        System.out.println(maxChain(pairs));
    }
}
