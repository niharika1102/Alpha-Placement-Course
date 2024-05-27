public class MergeSort {
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

    //Merging sorted Linked List
    public Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);    //auxillary node
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            }
            else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        //Copy remaining elements of split ll
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;    //We have to remove the auxillary node
    }

    public Node mergeSort(Node head) {     //Returns head od the merged LL
        //Base case
        if (head == null || head.next == null) {    //empty or 1 element
            return head;
        }

        //Find mid node
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node midNode = slow;

        //Split ll
        Node rightHead = midNode.next;    //right split
        midNode.next = null;      //left split

        //Sorting both halves
        Node newLeft = mergeSort(head);     //sorting left half
        Node newRight = mergeSort(rightHead);    //sorting right half

        //Merge sorted ll
        return merge(newLeft, newRight);
    }

    public static void main(String[] args) {
        MergeSort ll = new MergeSort();
        ll.addLast(1);
        ll.addLast(13);
        ll.addLast(67);
        ll.addLast(88);
        ll.addLast(12);
        ll.addLast(33);
        // ll.addLast(45);

        ll.print();
        System.out.println();
        System.out.println("----------------------");

        ll.mergeSort(head);
        ll.print();
    }
}
