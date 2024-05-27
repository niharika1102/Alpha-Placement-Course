import java.util.*;

public class QueueUsingArray {
    static class Queue {
        static int arr[];      //To implement the queue
        static int size;      //Size of the queue
        static int rear;

        Queue(int n) {        //n is the size of queue
            //Initializing the array with size n
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public boolean isEmpty() {
            return rear == -1;       //If rear is -1, it means that there is no element at the first position in the array
        }

        public void add(int data) {
            if (rear == size - 1) {    //Array is full
                System.out.println("Queue full");
                return;
            }

            rear = rear + 1;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue empty");
                return -1;
            }

            int front = arr[0];
            for (int i = 0; i < rear; i++) {   //To move the elements to one previous index
                arr[i] = arr[i + 1];
            }

            rear--;
            return front;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue empty");
                return -1;
            }

            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }
}
