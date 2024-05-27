import java.util.*;

public class MaximumInArrayList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        int ele = input.nextInt();

        for (int i = 0; i < ele; i++) {
            int num = input.nextInt();
            list.add(num);
        }

        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }

        System.out.println(max);

        input.close();
    }
}
