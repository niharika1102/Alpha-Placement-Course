import java.util.*;

public class ReverseAQueue {
    public static void reverse(Queue<Integer> q) {
        Stack <Integer> st = new Stack<>();

        while (!q.isEmpty()) {     //Storing the elements of the queue in the stack
            st.push(q.remove());
        }

        while (!st.isEmpty()) {     //Transfering stack elements back to the queue
            q.add(st.pop());
        }

        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= 5; i++) {
            q.add(i);
        }

        reverse(q);
    }
}
