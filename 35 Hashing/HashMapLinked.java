import java.util.*;

public class HashMapLinked {
    public static void main(String[] args) {
        LinkedHashMap <String, Integer> hm = new LinkedHashMap<>();

        hm.put("India", 100);
        hm.put("USA", 50);
        hm.put("Pakistan", 40);

        System.out.println(hm);
    }
}