import java.util.*;

public class OperationsOnHashMap {
    public static void main(String[] args) {
        //Creating a hashmap
        HashMap<String, Integer> hm = new HashMap<>();

        //Adding values to the hashmap
        hm.put("India", 100);
        hm.put("China", 130);
        hm.put("Russia", 90);
        hm.put("USA", 70);
        hm.put("Nepal", 30);

        System.out.println(hm);

        System.out.println("************************************************");

        //Get method
        System.out.println(hm.get("India"));
        System.out.println(hm.get("UAE"));    //null output due to non-existant key

        System.out.println("************************************************");

        //Contains key
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("UAE"));

        System.out.println("************************************************");

        //Remove method
        System.out.println(hm.remove("China"));
        System.out.println(hm);

        
        System.out.println("************************************************");

        //Size
        System.out.println("Size: " + hm.size());

        System.out.println("************************************************");

        //Empty hashmap
        System.out.println("Hashmap is empty: " + hm.isEmpty());

        System.out.println("************************************************");

        //Clear the hashmap
        hm.clear();
        System.out.println("Hashmap is empty: " + hm.isEmpty());
    }
}
