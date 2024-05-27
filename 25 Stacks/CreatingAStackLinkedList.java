public class CreatingAStackLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head = null;

        public boolean isEmpty() {
            if (head == null) {
                return true;
            }
            return false;
        }

        //push
        public void push(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        //pop
        public int pop() {
            if (head == null) {
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        //peek
        public int peek() {
            if (head == null) {
                return -1;
            }

            int top = head.data;
            return top;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);

        while (!s.isEmpty()) {
            int top = s.peek();
            System.out.println(top);
            s.pop();
        }
    }
}
