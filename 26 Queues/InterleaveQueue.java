import java.util.*;

public class InterleaveQueue {
    public static void interleave(Queue<Integer> q) {
        int size = q.size();
        Queue<Integer> newQ = new LinkedList<>();

        for (int i = 0; i < size / 2; i++) {    //Storing the first half of the queue in another queue
            newQ.add(q.peek());
            q.remove();
        }

        while (!newQ.isEmpty()) {      //Interleaving in the order: newQ -> q -> newQ -> q...
            q.add(newQ.remove());
            q.add(q.remove());
        }

        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= 10; i++) {
            q.add(i);
        }

        interleave(q);
    }
}
