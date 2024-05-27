import java.util.*;

public class ChocolaProblem {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = {2,1,3,1,4};
        Integer costHor[] = {4,1,2};

        //Sorting costs
        Arrays.sort(costVer, Comparator.reverseOrder());
        Arrays.sort(costHor, Comparator.reverseOrder());

        //Variables
        int h = 0, v = 0;    //Specific cut at that point of time
        int hp = 1, vp = 1;   //No. of cuts

        int cost = 0;
        while (h < costHor.length && v < costVer.length) {
            if (costHor[h] >= costVer[v]) {    //horizontal cut
                cost += (vp * costHor[h]);     //No. of vertical pieces * horizontal cost of 1 piece
                hp++;     //Horizontal cut => increase in horizontal pieces
                h++;
            }

            else {    //Vertical cut
                cost += (hp * costVer[v]);
                vp++;
                v++;
            }   
        }

        //Leftover cuts
        while (h < costHor.length) {
            cost += (vp * costHor[h]);     //No. of vertical pieces * horizontal cost of 1 piece
            hp++;     //Horizontal cut => increase in horizontal pieces
            h++;
        }

        while (v < costVer.length) {
            cost += (hp * costVer[v]);
            vp++;
            v++;
        }

        System.out.println(cost);
    }
}
