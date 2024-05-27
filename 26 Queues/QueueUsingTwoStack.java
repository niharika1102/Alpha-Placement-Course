import java.util.*;

public class QueueUsingTwoStack {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty();    //If s1 is empty, the queue will automatically be empty
        }

        public void add(int data) {
            //If s1 is not empty, store all elements of s1 in s2 and then add the data to s1. After that, transfer back all the elements of s2 back to s1.
            while (!s1.isEmpty()) {
                int temp = s1.pop();
                s2.push(temp);
            }

            //If s1 is empty in the starting also, the element is directly pushed in s1 because the condition of the previous while loop becomes false.
            s1.push(data);

            while (!s2.isEmpty()) {
                int temp = s2.pop();
                s1.push(temp);
            }
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue empty");
                return -1;
            }

            return s1.pop();
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue empty");
                return -1;
            }

            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }
}
