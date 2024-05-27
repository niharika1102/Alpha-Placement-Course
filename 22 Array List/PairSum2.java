import java.util.*;

public class PairSum2 {
    public static boolean checkPair(ArrayList<Integer> al, int target) {
        Collections.sort(al);
        int left = 0;
        int right = al.size() - 1;

        while (left < right) {
            if (al.get(left) + al.get(right) == target) {
                printNums(al.get(left), al.get(right));
                return true;
            }

            else if (al.get(right) + al.get(left) < target) {
                left++;
            }

            else {
                right--;
            }
        }

        return false;
    }

    public static void printNums(int a, int b) {
        System.out.println(a);
        System.out.println(b);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Integer> al = new ArrayList<>();
        al.add(11);
        al.add(15);
        al.add(6);
        al.add(8);
        al.add(9);
        al.add(10);

        int target = 16;
        checkPair(al, target);
        
        input.close();
    }
}
