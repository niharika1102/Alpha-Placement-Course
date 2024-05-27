import java.util.*;

public class ReversingArrayList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        int ele = input.nextInt();

        for (int i = 0; i < ele; i++) {
            int num = input.nextInt();
            list.add(num);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }

        input.close();
    }
}
