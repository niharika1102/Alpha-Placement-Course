import java.util.*;

public class QueueUsingLinkedList {
    static class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        public static Node head = null;
        public static Node tail = null;

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        public void add(int data) {
            //Add data at tail of linked list
            Node newNode = new Node(data);

            if (head == null) {       //Adding at first index
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue empty");
                return -1;
            }

            int front = head.data;

            //Single element
            if (head.next == null) {
                head = tail = null;
            }
            else {
                head = head.next;
            }

            return front;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue empty");
                return -1;
            }

            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }

    }
}
