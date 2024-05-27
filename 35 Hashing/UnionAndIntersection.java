import java.util.*;

public class UnionAndIntersection {
    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        HashSet<Integer> union = new HashSet<>();

        //union
        for (int i = 0; i < arr1.length; i++) {
            union.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            union.add(arr2[i]);
        }

        System.out.println(union);

        //intersection
        HashSet<Integer> inter = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            inter.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            int count = 0;

            if (inter.contains(arr2[i])) {
                System.out.print(arr2[i] + " ");
                count--;
                inter.remove(arr2[i]);
            }
        }
    }
}
