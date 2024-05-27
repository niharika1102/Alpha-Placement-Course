import java.util.*;

public class LargestSubarrayWithZeroSum {
    public static void main(String[] args) {
        int arr[] = {15,-2,2,-8,1,7,10};

        HashMap<Integer, Integer> hm = new HashMap<>();   //store sum, index pair
        int sum = 0;
        int len = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (hm.containsKey(sum)) {      //maximum out of length stored in array and j - i is stored in the hashmap
                len = Math.max(len, j - hm.get(sum));
            }
            else {     //pair is put in the hashmap
                hm.put(sum, j);
            }
        }

        System.out.println(len);
    }
}
