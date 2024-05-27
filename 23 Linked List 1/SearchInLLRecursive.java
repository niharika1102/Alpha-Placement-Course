public class SearchInLLRecursive {
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

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int index = helper(head.next, key);
        if (index == -1) {
            return -1;
        }

        return index + 1;

    }

    public int search(int key) {
        return helper(head, key);    
    }

    public static void main(String[] args) {
        SearchInLLRecursive ll = new SearchInLLRecursive();
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

        int pos = ll.search(67);
        System.out.println(pos);
    }
}
