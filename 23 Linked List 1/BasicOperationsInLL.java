public class BasicOperationsInLL {
    public static class Node {
        int data;
        Node next;

        public Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size = 1;

    //Add at head position
    public void addFirst(int data) {
        //Create new node
        Node newNode = new Node(data);    //New node initialized with data

        //Say linked List is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        //Next of new node points to head
        newNode.next = head;      //This steps creates the links between new node and head. Responsible for linking of the linked list.

        //Head points to new node
        head = newNode;

        //Update size
        size++;
    }    

    //Add at tail position
    public void addLast(int data) {
        //Create a new node
        Node newNode = new Node(data);

        //If LL is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        //Next of tail points to new node
        tail.next = newNode;

        //new node becomes the tail now
        tail = newNode;

        //Update size
        size++;
    }

    //Printing ll
    public void printLL() {
        //If ll is empty
        if (head == null) {
            System.out.println("Empty LL!!");
        }

        //Create new node 'temp' and point it to head
        Node temp = head;

        while (temp != null) {
            //Print temp data
            System.out.print(temp.data + " ");

            //Increment temp
            temp = temp.next;
        }
    }

    //Add at any index
    public void addMiddle(int data, int index) {
        //Add at start position
        if (index == 0) {
            addFirst(data);
        }
        //Create new node
        Node newNode = new Node(data);

        //Creating temp to point to head
        Node temp = head;

        //Traversing to reach index - 1
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        //Connect new node to its next node
        newNode.next = temp.next;

        //Connect new node to its previous node
        temp.next = newNode;

        //Update size
        size++;
    }

    //Removing head
    public int removeFirst() {
        //Empty LL
        if (size == 0) {
            System.out.println("Empty LL!!");
        }
        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;

        size--;

        return val;
    }

    //Remove tail
    public int removeLast() {
        //Addressing spl cases
        if (size == 0) {
            System.out.println("Empty LL!!");
        }
        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        //We use the size parameter to reach the second last element directly
        //Since, tail = size - 1. So, prev = size - 2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        //Now, we are on the second last index
        prev.next = null;
        int data = tail.data;
        tail = prev;

        size--;

        return data;
    }

    public static void main(String[] args) {
        BasicOperationsInLL ll = new BasicOperationsInLL();

        //addFirst
        ll.addFirst(1);
        ll.addFirst(2);

        //addLast
        ll.addLast(3);
        ll.addLast(4);

        //addMiddle
        ll.addMiddle(9, 2);

        //Printing ll
        ll.printLL();
        System.out.println();

        System.out.println("**************************");


        //removeFirst
        int data = ll.removeFirst();
        System.out.println("Removed value: " + data);

        //removeLast
        int val = ll.removeLast();
        System.out.println("Removed value: " + val);


        //Printing ll
        ll.printLL();
        System.out.println();

        System.out.println("**************************");

        //Printing size
        System.out.println(size);
    }
}
