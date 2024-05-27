import java.util.*;

public class CheapestFlights {
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

    static class Info {
        int vertex;
        int cost;
        int stops;

        public Info(int vertex, int cost, int stops) {
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            graph[src].add(new Edge(src, dest, wt));
        }
    }

    public static int cheapestFlights(int n, int flights[][], int src, int dest, int k) {
        //Creating graph
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        //distance array
        int dist[] = new int[n];

        //Initializing dist array
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        //Queue to store the information of the node traversed
        Queue<Info> q = new LinkedList<>();

        //Adding source node info to the queue
        q.add(new Info(src, 0, 0));     //Initially, stops and cost both are 0 for the source node.

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {      //no. of stops taken has exceeded the value of k, so, we can't get the correct answer from this path now
                break;
            }

            //Travelling the neighbours
            for (int i = 0; i < graph[curr.vertex].size(); i++) {
                Edge e = graph[curr.vertex].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                //Relaxation step
                if (dist[u] != Integer.MAX_VALUE && curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = dist[u] + wt;
                    
                    //Adding the new node to the queue
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {     //No path exists
            return -1;
        }
        else {
            return dist[dest];
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};

        int src = 0;
        int dest = 3;
        int k = 1;

        System.out.println(cheapestFlights(n, flights, src, dest, k));
    }
}
