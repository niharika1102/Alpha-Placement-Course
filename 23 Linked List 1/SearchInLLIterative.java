public class SearchInLLIterative {
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

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public int search(int key) {
        if (head == null) {
            System.out.println("Empty LL!!");
        }

        int i = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            i++;
            temp = temp.next;
        }

        return -1;
    }

    public void print() {
        if (head == null) {
            System.out.println("Empty LL!!");
        }

        Node temp = head;

        for (int i = 0; i < size; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SearchInLLIterative ll = new SearchInLLIterative();
        ll.addLast(1);
        ll.addLast(13);
        ll.addLast(67);
        ll.addLast(88);
        ll.addLast(12);
        ll.addLast(0);
        ll.addLast(45);

        ll.print();
        System.out.println();
        System.out.println("----------------------");

        int pos = ll.search(6);
        System.out.println(pos);
    }
}
