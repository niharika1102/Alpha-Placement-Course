import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();

        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(2);
        hs.add(8);

        System.out.println(hs);

        if (hs.contains(3)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }

        hs.remove(2);
        System.out.println(hs);
    }
}
