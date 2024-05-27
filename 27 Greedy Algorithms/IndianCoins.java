import java.util.*;

public class IndianCoins {
    public static int minDeno(Integer coins[], int amt) {
        Arrays.sort(coins, Comparator.reverseOrder());    //To sort in reverse order

        int count = 0;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amt) {
                while (coins[i] <= amt) {
                    count++;
                    amt = amt - coins[i];
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        int amt = 590;

        System.out.println(minDeno(coins, amt));
    }
}
