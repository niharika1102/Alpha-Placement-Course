import java.util.*;

public class TreeHashMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();

        tm.put("India", 500);
        tm.put("China", 40);
        tm.put("Kenya", 20);

        System.out.println(tm);
    }
}
