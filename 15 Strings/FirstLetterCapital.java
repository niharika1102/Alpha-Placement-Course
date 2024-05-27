import java.util.*;

public class FirstLetterCapital {

    public static String toCapital(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));

        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ' && i < str.length() - 1) {
                sb.append(ch);
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String str = input.nextLine();
        String ans = toCapital(str);
        System.out.println(ans);
        
        input.close();
    }
}