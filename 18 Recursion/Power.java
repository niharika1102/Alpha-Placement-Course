import java.util.Scanner;

public class Power {

    public static int power(int x, int n) {
        if (n == 1) {
            return x;
        }
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int x = input.nextInt();
        int n = input.nextInt();

        int res = power(x, n);
        System.out.println(res);
        
        input.close();
    }
}
