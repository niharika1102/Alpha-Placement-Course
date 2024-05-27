import java.util.*;

public class OperationsInHeap {
    static class Heap {
        ArrayList <Integer> arr = new ArrayList<>();

        public void addEle(int data) {
            //add element at last of heap
            arr.add(data);

            //fixing heap
            //Step 1: Finding index of parent
            int x = arr.size() - 1;   //child index
            int parent = (x - 1) / 2;

            //Step 2: Swapping if necessary
            while (arr.get(x) < arr.get(parent)) {     //For max heap, change sign
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                //Updating parent and child positions
                x = parent;
                parent = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);     //smallest element is stroed at root of the heap i.e. index 0 of the arraylist
        }

        public void heapify(int i) {     //i is the index from where the heap has to be fixed
            //Calculating left and right child
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            //Assigning min to i for comparison 
            int min = i;

            //For max heap, change sign of secind condition
            if (left < arr.size() && arr.get(min) > arr.get(left)) {    //First condition checks if the left child is a leaf node  //Second condition checks for heap property
                min = left;
            }

            //For max heap, change sign of secind condition
            if (right < arr.size() && arr.get(min) > arr.get(right)) {   //First condition checks if the right child is a leaf node   //Second condition checks for heap property
                min = right;
            }

            if (min != i) {
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(min));
                arr.set(min, temp);

                heapify(min);     //it could be possible that the heap gets disturbed due to swapping. So, we heapify again at min.
            }
        }

        public int remove() {
            int data = arr.get(0);    //data to be removed

            //Swap first and last element of the arraylist
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            //Remove last element
            arr.remove(arr.size() - 1);

            //Fix heap using heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.addEle(3);
        h.addEle(4);
        h.addEle(1);
        h.addEle(5);

        while (!h.isEmpty()) {
            System.out.print(h.peek() + " ");
            h.remove();
        }
    }
}
