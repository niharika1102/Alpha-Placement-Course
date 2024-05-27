import java.util.*;

public class SortingAnArrayList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(21);
        list.add(89);
        list.add(73);
        list.add(0);
        list.add(1);

        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(21);
        list1.add(89);
        list1.add(73);
        list1.add(0);
        list1.add(1);

        Collections.sort(list1, Collections.reverseOrder());
        System.out.println(list1);
        
        input.close();
    }
}
