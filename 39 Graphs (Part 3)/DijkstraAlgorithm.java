import java.util.*;

public class DijkstraAlgorithm {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge (int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {     //To store the distance of each node from source
        int node;
        int path;

        public Pair(int node, int path) {
            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;      //sorting based on path
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];    //to store distance of each node from source

        //Initializing all distances to be infinite
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;     //infinity distance
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[graph.length];

        pq.add(new Pair(src, 0));    //First pair is from src to src

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();   //remove pair with min dist
            if (visited[curr.node] == false) {    //if the current node is not visited
                visited[curr.node] = true;

                //Update neighbour distance
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) {    //Core of dijkstra    //Update dist of src to v
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        //print all distances
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Distance from " + src + " to " + i + ": " + dist[i]);
        }

    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        int src = 0;
        dijkstra(graph, src);
    }
}
