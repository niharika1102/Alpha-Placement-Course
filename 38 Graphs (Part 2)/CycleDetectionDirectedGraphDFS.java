import java.util.*;

public class CycleDetectionDirectedGraphDFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false) {    //current node is not visitd yet
                if (isCycleUtil(graph, i, visited, stack)) {     //if the util method returns true, cycle exists and we return true
                    return true;
                }
            }
        }

        return false;    //no cycle exists
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean visited[], boolean stack[]) {
        visited[curr] = true;   //current node is now visited
        stack[curr] = true;    //curr has entered stack calls

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest] == true) {     //neighbour is already in the stack. This means that we have reached the neighbour node earlier. 
                return true;
            }
            if (visited[e.dest] == false && isCycleUtil(graph, e.dest, visited, stack)) {     //neighbour is not visited and when we call util mehtod for the neighbour, it returns true. This means there is cycle
                return true;
            }
        }

        stack[curr] = false;     //current node is removed from the stack
        return false;
    }

    public static void main(String[] args) {
        //Graph
        // 1 ---> 0
        //        | ^
        //        |  \
        //        |   \
        //        |    3
        //        |    ^
        //        |   /
        //        |  /
        //        ~ /
        //        2

        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}
