import java.util.*;

public class BridgeInGraph {
    static class Edge {
        int src;
        int dest;

        public Edge (int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int parent, int dt[], int low[], boolean visited[], int time) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;    //initially, low and dt are same

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if (neigh == parent) {      //neighbour of current node is its parent, so ignore
                continue;
            }
            else if (visited[neigh] == false) {     //nieghbour is not visited, call dfs and update low time
                dfs(graph, neigh, curr, dt, low, visited, time);
                low[curr] = Math.min(low[curr], low[neigh]);

                //Bridge condition
                if (dt[curr] < low[neigh]) {
                    System.out.println("Bridge from " + curr + " to " + neigh);
                }
            }
            else {     //neighbour is visited. Just update low[curr]
                low[curr] = Math.min(low[curr], dt[neigh]);
            }

        }
    }

    public static void tarjanAlgo(ArrayList<Edge> graph[], int V) {
        int time = 0;
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                dfs(graph, i, -1, dt, low, visited, time);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        tarjanAlgo(graph, V);
    }
}
