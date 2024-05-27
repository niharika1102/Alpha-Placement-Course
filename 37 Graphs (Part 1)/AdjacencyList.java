import java.util.*;

public class AdjacencyList {
    //Class to store data of the edges
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static void main(String[] args) {
        //Graph:
        //     0
        //     |           4
        //     |          /
        //     |         / (2)
        // (5) |        /
        //     |       2
        //     |     /   \
        //     |    /(1)  \ (1)
        //     |   /       \
        //     |  /         \
        //     1 ----------- 3
        //             (3)

        int V = 5;    //no. of vertices
        //Size of arrayList = no. of edges
        ArrayList<Edge>[] graph = new ArrayList[V];      //On every index of array, we store an arraylist which stores the data of the edges.

        //Initializing an empty array list on each index of array
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        //Storing value for vertex 0
        graph[0].add(new Edge(0, 1, 5));

        //Storing value for vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        //Storing value for vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        //Storing value for vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        //Storing value for vertex 4
        graph[4].add(new Edge(4, 2, 2));

        //Printing neighbours of 2
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.dest + " ");
        }
    }
}
