import java.util.*;

public class CreatingAStackArrayList {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            if(list.size() == 0) {
                return true;
            }
            return false;
        }

        //Push method
        public static void push(int data) {
            list.add(data);
        }

        //Pop method
        public static int pop() {
            //If stack becomes empty
            if (isEmpty()) {
                return -1;
            }

            int ele = list.get(list.size() - 1);     //O(1)
            list.remove(list.size() - 1);        //O(1)
            return ele;
        }

        //Peek method
        public static int peek() {
            //If stack becomes empty
            if (isEmpty()) {
                return -1;
            }

            int ele = list.get(list.size() - 1);
            return ele;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        // System.out.println(s.peek());

        while (!s.isEmpty()) {
            int top = s.peek();
            System.out.println(top);
            s.pop();
        }
    }    
}
