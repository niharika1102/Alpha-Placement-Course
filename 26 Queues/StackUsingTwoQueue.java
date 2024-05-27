import java.util.*;

public class StackUsingTwoQueue {
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public void add(int data) {
            //We add the data in the queue which is not empty

            if (!q1.isEmpty()) {
                q1.add(data);
            }
            else {
                q2.add(data);
            }
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Stack empty");
                return -1;
            }

            int top = -1;
            
            //case 1 (q1 has elements)
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {    //Store the first element of queue to a variable. If the queue becomes empty, break from the loop and return that element. If not, add the first element to the other queue.
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            }
            else {    //case 2 (q2 has elements)
                while (!q2.isEmpty()) {    //Store the first element of queue to a variable. If the queue becomes empty, break from the loop and return that element. If not, add the first element to the other queue.
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }

            return top;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack empty");
                return -1;
            }

            int top = -1;
            
            //case 1 (q1 has elements)
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {    //Store the first element of queue to a variable. If the queue becomes empty, break from the loop and return that element. If not, add the first element to the other queue.
                    top = q1.remove();
                    q2.add(top);
                }
            }
            else {    //case 2 (q2 has elements)
                while (!q2.isEmpty()) {    //Store the first element of queue to a variable. If the queue becomes empty, break from the loop and return that element. If not, add the first element to the other queue.
                    top = q2.remove();
                    q1.add(top);
                }
            }

            return top;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();

        st.add(1);
        st.add(2);
        st.add(3);
        st.add(4);

        while (!st.isEmpty()) {
            System.out.println(st.peek());
            st.remove();
        }
    }
}
