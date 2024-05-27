import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int nums[] = {1,3,2,5,1,3,5,1};

        int size = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < size; i++) {
            int n = nums[i];

            // if (freq.containsKey(n)) {      //n already exists in the hashmap, so count is incremented
            //     freq.put(n, freq.get(n) + 1);
            // }
            // else {              //n is not present in the hashmap, so count is set to 1
            //     freq.put(n, 1);
            // }

            //Shorthand notation
            freq.put(n, freq.getOrDefault(n, 0) + 1);    //If key exists, value is incremented from its prev value. If it doesn't exist, value is incremented from 0.
        }

        int count = size / 3;

        Set<Integer> keys = freq.keySet();      //Storing all the keys in a set
        for (Integer i: keys) {
            if (freq.get(i) > count) {    //if value in the key-value pair > count, key is printed
                System.out.print(i + " ");
            }
        }
    }
}
