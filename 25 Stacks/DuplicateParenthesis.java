import java.util.*;

public class DuplicateParenthesis {
    public static boolean checkDuplicate(String str) {
        Stack <Character> st = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == ')') {
                int count = 0;
                while(st.peek() != '(') {
                    count++;
                    st.pop();
                }
                if (count < 1) {
                    return true;
                }
                else {
                    st.pop();
                }
            }
            else {
                st.push(c);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // String str = "(((a + (b))) + (c + d))";
        String str2 = "((a + b) + (c + d))";

        System.out.println(checkDuplicate(str2));
    }
}
