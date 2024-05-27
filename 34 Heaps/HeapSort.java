public class HeapSort {
    public static void heapify(int arr[], int i, int size) {
        //finding left and right child index
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int max = i;

        if (left < size && arr[left] > arr[max]) {
            max = left;
        }

        if (right < size && arr[right] > arr[max]) {
            max = right;
        }

        if (max != i) {
            //swap
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }
    }

    public static void heapSort(int arr[]) {
        //step 1: build max heap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            //calling heapify for i
            heapify(arr, i, n);     //heapify takes in index to heapify and size of heap
        }

        //step 2: push largest element to last
        for (int i = n - 1; i > 0; i--) {
            //swap the largest element with the last element of heap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //fixing heap
            heapify(arr, 0, i);
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,3};

        heapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
