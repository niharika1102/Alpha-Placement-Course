import java.util.*;

public class LinkedListInJCF {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        //add first
        ll.addFirst(1);
        ll.addFirst(2);

        //add last
        ll.addLast(3);
        ll.addLast(4);

        //print
        System.out.println(ll);

        //remove first
        ll.removeFirst();

        //remove last
        ll.removeLast();

        //print
        System.out.println(ll);
    }     
}
