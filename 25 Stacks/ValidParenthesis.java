import java.util.*;

public class ValidParenthesis {
    public static boolean checkValid(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == '[' || c == '{' || c == '(') {
                st.push(c);
            }

            else {
                if (st.isEmpty()) {
                    return false;
                }

                else if (c == ')' && st.peek() == '(') {
                    st.pop();
                }

                else if (c == '}' && st.peek() == '{') {
                    st.pop();
                }

                else if (c == ']' && st.peek() == '[') {
                    st.pop();
                }

                else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
    public static void main(String[] args) {
        String str = "{}";

        System.out.println(checkValid(str));
    }
}
