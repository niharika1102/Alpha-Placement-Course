import java.util.*;

public class BuyingAndSellingStocks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int prices[] = {7,1,5,3,6,4};

        int size = prices.length;

        //Making buyingPrice maximum to compare and find the minimum from the array
        int buyingPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < size; i++) {

            //If currentPrice > buyingPrice, we can have profit. So we calculate profit and check if it is maximum.
            if (buyingPrice < prices[i]) {
                int thisProfit = prices[i] - buyingPrice;
                maxProfit = Math.max(maxProfit, thisProfit);
            }

            //If currentPrice < buyingPrice, it will be loss for that day. But, the currentPrice can become the buyingPrice for the next day to incure profit.
            else {
                buyingPrice = prices[i];
            }
        }

        System.out.println(maxProfit);
        
        input.close();
    }
}
