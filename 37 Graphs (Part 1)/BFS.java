import java.util.*;

public class BFS {
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

    public static void createGraph (ArrayList<Edge> graph[]) {
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

    public static void bfs(ArrayList<Edge>[] graph) {     //Dealing with the unconnected components
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false) {
                bfsUtil(graph, visited);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();

        //Adding first node to the queue
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();

            if (visited[curr] == false) {    //node is not visited even once. So, we visit it.
                //Step 1: print the node
                System.out.print(curr + " ");

                //Step 2: Change the value of visited for that node
                visited[curr] = true;

                //Step 3: Add neighbours of curr to the queue
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
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
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        bfs(graph);
    }
}