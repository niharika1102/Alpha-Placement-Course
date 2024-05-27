public class ZigZag {
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

    public void zigZag() {
        //find mid
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        //half reverse
        Node curr = mid.next;
        mid.next = null;

        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //concatenate
        Node leftH = head;
        Node rightH = prev;
        Node nextLeft, nextRight;

        while (leftH != null && rightH != null) {
            //Left side operations
            nextLeft = leftH.next;
            leftH.next = rightH;

            //Right side operations
            nextRight = rightH.next;
            rightH.next = nextLeft;

            //Update left and right head
            leftH = nextLeft;
            rightH = nextRight;
        }
    }

    public static void main(String[] args) {
        ZigZag ll = new ZigZag();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.print();
        System.out.println();
        System.out.println("----------------------");


        ll.zigZag();
        ll.print(); 
    }
}
