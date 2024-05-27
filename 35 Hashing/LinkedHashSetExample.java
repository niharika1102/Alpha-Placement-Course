import java.util.*;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("India");
        lhs.add("China");
        lhs.add("USA");
        lhs.add("Kenya");

        System.out.println(lhs);
    }
}
