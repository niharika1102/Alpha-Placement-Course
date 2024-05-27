import java.util.*;

public class StringCompression {

    public static String Compress(String str) {
        String ans = "";
        // sb.append(str.charAt(0));
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Integer count = 1;
            while (i < str.length() - 1 && ch == str.charAt(i + 1)) {
                count++;
                i++;
            }

            ans = ans + str.charAt(i);

            if (count > 1) {
                ans = ans + count.toString();
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String str = input.nextLine();
        String ans = Compress(str);

        System.out.println(ans);

        input.close();
    }
}
