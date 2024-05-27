import java.util.*;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Integer> list = new ArrayList<>();
        int size = input.nextInt();

        for (int i = 0; i < size; i++) {
            int num = input.nextInt();
            list.add(num);
        }

        int index1 = input.nextInt();
        int index2 = input.nextInt();

        int num1 = list.get(index1);
        int num2 = list.get(index2);

        int temp = num1;
        list.set(index1, num2);
        list.set(index2, temp);

        System.out.println(list);
        
        input.close();
    }
}
