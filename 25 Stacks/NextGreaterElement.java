import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1, 3};
        Stack<Integer> st = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            //to remove smaller elements
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {     //Stack has elements and the element on top of stack is less than or equal to the element we are working with
                st.pop();
            }
            
            //If stack if empty, next greater is -1.
            if (st.isEmpty()) {
                nextGreater[i] = -1;
            }

            //If stack has elements, next greater is element at top index of array from stack.
            else {
                nextGreater[i] = arr[st.peek()];
            }

            st.push(i);
        }

        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }

    }
}
