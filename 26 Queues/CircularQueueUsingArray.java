public class CircularQueueUsingArray {
    class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        public Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public boolean isfull() {
            return (rear + 1) % size == front;     //If rear is just one index behind front
        }

        public void add(int data) {
            if(isfull()) {
                System.out.println("Queue full");
                return;
            }

            if (front == -1) {      //Adding element for the first time in queue
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;

        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue empty");
                return -1;
            }

            int result = arr[front];

            if (rear == front) {     //If we are deleting the last element of the queue
                rear = front = -1;
            }
            else {
                front = (front + 1) % size;
            }
            return result;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue empty");
                return -1;
            }

            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(0);

        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }
}
