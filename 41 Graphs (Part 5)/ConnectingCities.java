import java.util.*;

public class ConnectingCities {
    static class Edge implements Comparable<Edge> {
        int dest;
        int wt;

        public Edge (int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[cities.length];

        //Adding source to PQ
        pq.add(new Edge(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();

            if (visited[curr.dest] == false) {
                visited[curr.dest] = true;
                finalCost += curr.wt;

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0) {     //Edge exists
                        pq.add(new Edge(i, cities[curr.dest][i]));     //Adding neighbour edge info to the PQ
                    }
                }
            }
        }

        return finalCost;
    }

    public static void main(String[] args) {
        int cities[][] = {{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};

        System.out.println(connectCities(cities));
    }
}
