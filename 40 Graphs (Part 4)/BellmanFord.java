import java.util.*;

public class BellmanFord {
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

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    public static void createGraph2(ArrayList<Edge> graph) {     //Order of edges does not matter here
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];

        //Initializing dist to infinity
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;

        //Performing operations for V - 1 times
        for (int i = 0; i < V - 1; i++) {

            //Finding edges for all vertices of the graph
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    //Relaxation step
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {    //If u == infinity, the shortest path can't go through u.
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println("Distance between " + src + " and " + i + ": " + dist[i]);
        }
    }

    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V) {
        int dist[] = new int[V];

        //Initializing dist to infinity
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        //Performing operations for V - 1 times
        for (int i = 0; i < V - 1; i++) {

            //Finding edges for all vertices of the graph
            for (int j = 0; j < graph.size(); j++) {
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                //Relaxation step
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {    //If u == infinity, the shortest path can't go through u.
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println("Distance between " + src + " and " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);

        ArrayList<Edge> graph = new ArrayList<>();
        createGraph2(graph);

        int src = 0;
        // bellmanFord(graph, src);        
        bellmanFord2(graph, src, V);
    }
}
