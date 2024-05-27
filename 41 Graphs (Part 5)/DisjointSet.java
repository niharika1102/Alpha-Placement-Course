import java.util.*;

public class DisjointSet {
    //Initializing n, parent and rank
    static int n = 7;
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    //intializing parent of i as i
    public static void init() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    //Find method
    public static int find(int x) {
        if (x == parent[x]) {       //i is the parent of itself
            return x;
        }

        return find(parent[x]);     //in case of any union, we make a recursive call to the parent of x to find its parent i.e. supreme parent
    }

    public static void union (int a, int b) {
        //Parents of a and b
        int parentA = find(a);
        int parentB = find(b); 

        if (rank[parentA] == rank[parentB]) {     //if ranks are equal, any node can become the parent and the rank of the new parent is updated
            parent[parentB] = parentA;
            rank[parentA]++;
        }
        else if (rank[parentA] < rank[parentB]) {     //rank of parent A < parent B. But the final rank of parent is not updated in this case.
            parent[parentA] = parentB;
        }
        else {
            parent[parentB] = parentA;
        }
    }
    public static void main(String[] args) {
        init();
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        union(1, 5);
    }
}
