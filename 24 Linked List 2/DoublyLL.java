public class DoublyLL {
    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = null;
        head = newNode;

        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.next = null;
        tail = newNode;

        size++;
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("Empty LL!!");
        }

        head = head.next;
        head.prev = null;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("Empty LL!!");
        }

        tail.prev.next = null;
        tail = tail.prev;
        size--;
    }

    public void print() {
        if (head == null) {
            System.out.print("Empty LL!!");
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DoublyLL ll = new DoublyLL();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.removeFirst();
        // ll.removeLast();

        ll.print();
    }
}
