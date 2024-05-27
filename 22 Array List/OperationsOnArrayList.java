import java.util.*;

public class OperationsOnArrayList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Integer> list = new ArrayList<>();

        list.add(88);
        list.add(45);
        list.add(78);
        list.add(74);
        list.add(33);

        System.out.println(list);

        int ele = list.get(1);
        System.out.println(ele);

        list.remove(3);
        System.out.println(list);

        list.set(2, 100);
        System.out.println(list);

        System.out.println(list.contains(100));

        list.add(2, 550);
        System.out.println(list);

        System.out.println(list.size());

        //Printing the array list using loop
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        input.close();
    }
}