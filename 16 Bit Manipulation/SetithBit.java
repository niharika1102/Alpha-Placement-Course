// package 16 Bit Manipulation;
import java.util.*;

public class SetithBit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int i = input.nextInt();

        int bitMask = 1 << i;
        int operation = n | bitMask;

        System.out.println(operation);
        
        input.close();
    }
}
