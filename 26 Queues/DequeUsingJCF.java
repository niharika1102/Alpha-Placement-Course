import java.util.*;

public class DequeUsingJCF {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();

        dq.addFirst(1);
        dq.addFirst(2);
        dq.addFirst(3);
        dq.addLast(5);
        dq.addLast(4);

        System.out.println(dq);

        dq.removeFirst();
        dq.removeLast();

        System.out.println(dq);

        System.out.println(dq.getFirst() + " first");
        System.out.println(dq.getLast() + " last");
    }
}
