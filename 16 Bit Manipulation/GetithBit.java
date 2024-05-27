// package 16 Bit Manipulation;
import java.util.*;

public class GetithBit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int i = input.nextInt();

        int bitMask = 1 << i;
        int operator = n & bitMask;

        if (operator == 0) {
            System.out.println("0");
        }
        else {
            System.out.println("1");
        }

        input.close();
    }
}
