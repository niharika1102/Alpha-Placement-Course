import java.util.*;

public class StockSpan {
    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> st = new Stack<>();

        //The first element of span array is always 1
        span[0] = 1;
        st.push(0);     //Index for day 1 is 0;

        for (int i = 1; i < stocks.length; i++) {
            int curr = stocks[i];

            while (!st.isEmpty() && curr > stocks[st.peek()]) {       //Prices of all elements in the stack are smaller than curr
                st.pop();
            }

            if (st.isEmpty()) {    //Last element case
                span[i] = i + 1;
            }
            else {
                int prevHigh = st.peek();
                span[i] = i - prevHigh;
            }

            st.push(i);     //To check for next elements of stock array
        }
    }
    public static void main(String[] args) {
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];

        stockSpan(stocks, span);

        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
