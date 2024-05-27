import java.util.*;

public class ReverseAStack {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void reverse(Stack<Integer> s) {
        if (!s.isEmpty()) {
           int top = s.pop();
            reverse(s);
            pushAtBottom(s, top);
        }
        
    }
    public static void main(String[] args) {
        Stack <Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        // while (!s.isEmpty()) {
        //     int top = s.peek();
        //     System.out.println(top);
        //     s.pop();
        // }

        System.out.println("--------------------");

        reverse(s);
        while (!s.isEmpty()) {
            // int top = s.peek();
            System.out.println(s.pop());
            // s.pop();
        }
    }
}
