import java.util.*;

public class ConnectNRopesWithMinimumCost {
    public static void main(String[] args) {
        int ropes[] = {2,3,3,4,6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //Adding ropes to pq
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while (pq.size() > 1) {
            //removing 2 min values from pq
            int min1 = pq.remove();
            int min2 = pq.remove();
            
            //updating cost
            cost += min1 + min2;

            //adding new rope length to pq
            pq.add(min1 + min2);
        }

        System.out.println(cost);
    }
}
