import java.util.*;

public class StackUsingDeque {
    static class Stack {
        Deque<Integer> dq = new LinkedList<>();

        public void add(int data) {
            dq.addLast(data);
        }

        public int remove() {
            return dq.removeLast();
        }

        public int peek() {
            return dq.getLast();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);

        s.remove();
        System.out.println(s.peek());
    }
}
