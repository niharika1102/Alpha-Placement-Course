public class CheckPalindrome {
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

    // public boolean palindrome() {
        // boolean isPalindrome = false;

        // List <Integer> al = new ArrayList<>();
        // Node temp = head;
        // for (int i = 0; i < size; i++) {
        //     al.add(temp.data);
        //     temp = temp.next;
        // }

        // int i = 0;
        // int j = al.size() - 1;

        // while (i < j) {
        //     if (al.get(i) == al.get(j)) {
        //         isPalindrome = true;
        //     }
        //     i++;
        //     j++;
        // }

        // return isPalindrome;
    // }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       //Increment by 1
            fast = fast.next.next;   //Increment by 2
        }

        return slow;     //Gives the middle node
    }

    //Check Boolean
    public boolean Palindrome() {
        //Edge case
        if (head == null || head.next == null) {      //size of ll is either 0 or 1
            return true;
        }

        //Find mid
        Node mid = findMid(head);

        //Reverse second half
        Node prev = null;
        Node curr = mid;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;    //Head of the right part of the ll
        Node left = head;

        //Check left and right part
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
    
    public static void main(String[] args) {
        CheckPalindrome ll = new CheckPalindrome();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        // ll.addLast(1);

        ll.print();
        System.out.println();
        System.out.println("----------------------");

        boolean result = ll.Palindrome();
        System.out.println(result);
    }
}
