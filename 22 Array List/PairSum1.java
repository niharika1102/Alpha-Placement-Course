import java.util.*;

public class PairSum1 {
    public static boolean checkPairBrute(ArrayList<Integer> al, int target) {
        for (int i = 0; i < al.size(); i++) {
            for (int j = i + 1; j < al.size(); j++) {
                if (al.get(i) + al.get(j) == target) {
                    printNums(al.get(i), al.get(j));
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkPair(ArrayList<Integer> al, int target) {
        int len = al.size();
        int left = 0;
        int right = len - 1;

        while (left < right) {
            if (al.get(left) + al.get(right) == target) {
                printNums(al.get(left), al.get(right));
                return true;
            }

            else if (al.get(left) + al.get(right) < target) {
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
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);

        int target = 5;

        checkPairBrute(al, target);
        System.out.println("**********************************");
        checkPair(al, target);
        
        input.close();
    }
}
