import java.util.*;

public class ReverseAString {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();

        String str = "abc";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            s.push(ch);
        }

        while (!s.isEmpty()) {
            char top = s.peek();
            System.out.print(top);
            s.pop();
        }
    }
}
