import java.util.*;

public class BipartiteGraph {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        //Colour array
        int colour[] = new int[graph.length];

        for (int i = 0; i < colour.length; i++) {      //initializing array with -1
            colour[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (colour[i] == -1) {    //node is not yet coloured, so we perform bfs on it
                q.add(i);
                colour[i] = 0;

                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        //Case 3: Neighbour has no colour
                        if (colour[e.dest] == -1) {
                            int nextCol = -1;
                            if (colour[curr] == 1) {
                                nextCol = 0;
                            }
                            else if (colour[curr] == 0) {
                                nextCol = 1;
                            }

                            colour[e.dest] = nextCol;
                            q.add(e.dest);
                        }

                        //Case 1: Neighbour has same colour as current node
                        else if (colour[e.dest] == colour[curr]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //Graph
        //     0
        //    / \
        //   /   \
        //  1     2
        //  |     |
        //  |     |
        //  3 --- 4

        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}