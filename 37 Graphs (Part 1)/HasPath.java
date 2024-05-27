import java.util.*;

public class HasPath {
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

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        //Storing graph data
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean visited[]) {
        if (src == dest) {
            return true;
        }

        visited[src] = true;    //src has been visited now, so its value is updated

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);     //getting neighbours of src
            if (visited[e.dest] == false && hasPath(graph, e.dest, dest, visited)) {    //if the neighbour is not visited and a path exists between neighbour and destination, we return true
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        //Graph

        //     1 ------- 3
        //    /          | \
        //   /           |  \
        //  /            |   \
        // 0             |    5 ------ 6
        //  \            |   /
        //   \           |  /
        //    \          | /
        //     2 ------- 4

        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        boolean visited[] = new boolean[V];
        System.out.println(hasPath(graph, 0, 5, visited));
    }
}
