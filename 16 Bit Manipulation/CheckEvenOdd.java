// package 16 Bit Manipulation;
import java.util.*;

public class CheckEvenOdd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int andOperation = n & 1;

        if (andOperation == 0) {
            System.out.println("Even");
        }
        else {
            System.out.println("Odd");
        }
        
        input.close();
    }
}
