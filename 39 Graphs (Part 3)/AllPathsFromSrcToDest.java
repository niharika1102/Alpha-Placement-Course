import java.util.*;

public class AllPathsFromSrcToDest {
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

        graph[0].add(new Edge(0, 3));
        
        graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 1));
        
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void allPaths(ArrayList<Edge> graph[], int src, int dest, String path) {
        //Base case
        if (src == dest) {
            System.out.println(path + " " + dest);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            allPaths(graph, e.dest, dest, path + " " + src);
        }
    }

    public static void main(String[] args) {
        //Graph
        // 2 ---> 3 ---> 1
        // ^      ^      ^
        // |      |      |
        // |      |      |
        // 5 ---> 0 <--- 4 

        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        int src = 5, dest = 1;

        allPaths(graph, src, dest, "");
    }
}
