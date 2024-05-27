import java.util.*;

public class ArticulationPoint {
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

    public static void dfs(ArrayList<Edge> graph[], int curr, int parent, int dt[], int low[], int time, boolean visited[], boolean ap[]) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;

        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {     //Processing for neighbours
            Edge e = graph[curr].get(i);
            int neighbour = e.dest;

            //Neighbour is parent. ignore
            if (parent == neighbour) {
                continue;
            }
            else if (visited[neighbour] == true) {
                low[curr] = Math.min(low[curr], dt[neighbour]);
            }
            else {
                dfs(graph, neighbour, curr, dt, low, time, visited, ap);
                low[curr] = Math.min(low[curr], low[neighbour]);  
                if (parent != -1 && dt[curr] <= low[neighbour]) {    //Case 2 and 3 of AP
                    ap[curr] = true;
                }  

                children++;
            }
        }

        if (parent == -1 && children > 1) {    //Case 1
            ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge> graph[], int V) {
        int time = 0;
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean visited[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                dfs(graph, i, -1, dt, low, time, visited, ap);
            }
        }

        System.out.print("AP: ");

        for (int i = 0; i < ap.length; i++) {
            if (ap[i] == true) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        getAP(graph, V);
    }
}
