import java.util.*;

public class SlidingWindowMaximum {
    static class Pair implements Comparable<Pair> {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Pair p2) {
            //to create min heap, we use this.val - p2.val
            //To create max heap like here,
            return p2.val - this.val;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int n = arr.length;
        int k = 3;
        
        //creating new result array of size n - k + 1
        int res[] = new int[n - k + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //Storing first window as it is
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        //Getting max for first window
        res[0] = pq.peek().val;

        //For all other windows
        for (int i = k; i < n; i++) {
            while (pq.size() > 0 && pq.peek().index <= (i - k)) {    //The current element of pq lies outside the window, so, it is removed
                pq.remove();
            }

            //adding current element of the window to the array
            pq.add(new Pair(arr[i], i));

            //Finding max element of the current window
            res[i - k + 1] = pq.peek().val;
        }

        //printing res array
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
