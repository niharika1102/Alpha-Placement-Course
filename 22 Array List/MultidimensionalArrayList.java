import java.util.*;

public class MultidimensionalArrayList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //2D ArrayList
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        //Inner arraylist
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        al.add(list);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        al.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        al.add(list2);

        System.out.println(al);
        
        input.close();
    }
}
