import java.util.*;

public class FindItinary {
    //to get the starting point
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        //iterate over the original hashmap to get the keys and store them as key value pair in reverse in the new map
        for (String key: tickets.keySet()) {
            revMap.put(tickets.get(key), key);     //storing original key as the value and value as the key in the new map
        }

        //checking if the same keys exist in both the maps
        for (String key: tickets.keySet()) {
            if (!revMap.containsKey(key)) {       //in case where the key does not exist in both maps, it is the starting point of journey
                return key;
            }
        }

        return null;
    }
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bangalore");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start + " ");

        for (String key: tickets.keySet()) {
            System.out.print(tickets.get(start) + " ");
            start = tickets.get(start);
        }
    }
}