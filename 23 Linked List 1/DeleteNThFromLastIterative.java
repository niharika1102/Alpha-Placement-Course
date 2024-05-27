public class DeleteNThFromLastIterative {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size = 1;

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void print() {
        if (head == null) {
            System.out.print("Empty LL!!");
        }

        Node temp = head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void deleteMiddle(int pos) {
        int starting = size - pos;
        int i = 1;
        Node prev = head;

        if (pos == size) {
            head = head.next;
        }

        while (i < starting) {    //To reach the prev of target node
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;    //Point prev to target's next
        size--;
    }

    public static void main(String[] args) {
        DeleteNThFromLastIterative ll = new DeleteNThFromLastIterative();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);

        ll.print();
        System.out.println();
        System.out.println("----------------------");

        ll.deleteMiddle(2);
        ll.print();
    }
}
