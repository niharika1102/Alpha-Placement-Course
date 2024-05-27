import java.util.*;

public class NearbyCars {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int index;

        public Point(int x, int y, int distSq, int index) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.index = index;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }
    public static void main(String[] args) {
        int pts[][] = {{3,3}, {5,-1}, {-2,4}};
        int k = 2;

        //Storing points in the priority queue
        PriorityQueue <Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        //Printing nearest k cars
        for (int i = 0; i < k; i++) {
            System.out.print("C" + pq.remove().index + " ");
        }
    }
}
