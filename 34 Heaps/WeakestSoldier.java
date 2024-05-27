import java.util.*;

public class WeakestSoldier {
    static class Row implements Comparable<Row> {
        int soldiers;
        int index;

        public Row(int soldiers, int index) {
            this.soldiers = soldiers;
            this.index = index;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldiers == r2.soldiers) {    //if number of soldiers is equal, smaller index is returned
                return this.index - r2.index;
            }
            else {     //else, the row with less soldiers is returned
                return this.soldiers - r2.soldiers;
            }
        }
    }
    public static void main(String[] args) {
        int army[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}};

        int k = 2;

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i = 0; i < army.length; i++) {
            //counting soldiers in each line
            int count = 0;
            for (int j = 0; j < army[0].length; j++) {
                if (army[i][j] == 1) {
                    count++;
                }
            }

            //adding row to pq
            pq.add(new Row(count, i));
        }

        //printing weakest rows
        for (int i = 0; i < k; i++) {
            System.out.print("R" + pq.remove().index + " ");
        }
    }
}
