import java.util.*;

public class IterationOverHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 50);
        hm.put("Nepal", 10);
        hm.put("USA", 150);

        // //Iteration on the map
        // Set<String> country = hm.keySet();

        // //Printing keys
        // System.out.println(country);

        // //Getting values of each key
        // for (String c : country) {
        //     System.out.println("Key: " + c + ", Value: " + hm.get(c));
        // }

        //Another method to iterate
        System.out.println(hm.entrySet());
    }
}
