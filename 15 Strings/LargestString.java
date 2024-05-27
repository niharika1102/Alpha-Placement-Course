import java.util.*;

public class LargestString {

    public static String largest(String arr[]) {
        String res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (res.compareTo(arr[i]) < 0) {
                res = arr[i];
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();

        String arr[] = new String[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.next();     //Using nextLine will not take the last input in the array.
        }

        String ans = largest(arr);

        System.out.println(ans);
        
        input.close();
    }
}
