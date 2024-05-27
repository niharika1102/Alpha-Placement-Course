import java.util.*;

public class IterationOnHashSet {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();

        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);
        hs.add(5);
        hs.add(6);
        hs.add(7);

        Iterator it = hs.iterator();     //to call the iterator class and return the iterator for the hashset

        while (it.hasNext()) {    //till the time the next element exists, the next element is printed and it moves forward
            System.out.print(it.next() + " ");
        }

        System.out.println();

        //Enhanced for loop method
        for (int i: hs) {
            System.out.print(i + " ");
        }
    }
}
