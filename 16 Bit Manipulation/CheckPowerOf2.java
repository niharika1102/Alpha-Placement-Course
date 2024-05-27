import java.util.*;

public class CheckPowerOf2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();

        int operation = n & (n - 1);
        
        if (operation == 0) {
            System.out.println("Power of 2");
        }
        else {
            System.out.println("Not power of 2");
        }
        
        input.close();
    }
}
