public class CreatingNodeClass {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //since, there is only 1 head and 1 tail in the linked list, we decalre them as a propoerty of the class.
    public static Node head;
    public static Node tail;

    public static void main(String[] args) {
        CreatingNodeClass ll = new CreatingNodeClass();      //Creating object of class.
    }    
}
