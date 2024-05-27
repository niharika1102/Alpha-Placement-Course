import java.util.*;

public class ClearRangeOfBits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int i = input.nextInt();
        int j = input.nextInt();

        int a = ((~0) << (j + 1));
        int b = (i << i) - 1;

        int bitMask = a | b;
        int operation = n & bitMask;
        System.out.println(operation);
        
        input.close();
    }
}