public class MinMaxSTQuery {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void buildST(int arr[], int i, int Si, int Sj) {
        if (Si == Sj) {     //leaf node: base case
            tree[i] = arr[Si];
            return;
        }

        int mid = (Si + Sj) / 2;

        buildST(arr, 2 * i + 1, Si, mid);
        buildST(arr, 2 * i + 2, mid + 1, Sj);

        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;

        return getMaxUtil(0, 0, n - 1, qi, qj);
    }

    public static int getMaxUtil(int i, int Si, int Sj, int qi, int qj) {
        if (Si > qj || Sj < qi) {    //no overlap
            return Integer.MIN_VALUE;
        }

        else if (Si >= qi && Sj <= qj) {    //complete overlap
            return tree[i];
        }

        else {    //patial overlap
            int mid = (Si + Sj) / 2;
            int leftAns = getMaxUtil(2 * i + 1, Si, mid, qi, qj);
            int rightAns = getMaxUtil(2 * i + 2, mid + 1, Sj, qi, qj);
            return Math.max(leftAns, rightAns);
        }
    }

    public static void update(int arr[], int index, int newVal) {
        arr[index] = newVal;
        int n = arr.length;

        updateUtil(0, 0, n - 1, index, newVal);
    }

    public static void updateUtil(int i, int Si, int Sj, int index, int newVal) {
        if (index < Si || index > Sj) {
            return;
        }

        tree[i] = Math.max(tree[i], newVal);
        if (Si != Sj) {
            int mid = (Si + Sj) / 2;
            updateUtil(2 * i + 1, Si, mid, index, newVal);    //left child 
            updateUtil(2 * i + 2, mid + 1, Sj, index, newVal);   //rigth child
        }
    }

    public static void main(String[] args) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;

        init(n);
        buildST(arr, 0, 0, n - 1);

        System.out.println(getMax(arr, 2, 5));
        update(arr, 2, 20);
        System.out.println(getMax(arr, 2, 5));
    }
}
