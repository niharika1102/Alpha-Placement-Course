import java.util.*;

public class FractionalKnapsack {
    public static int maxValue(int weight[], int value[], int W) {
        //Calculating ratio and sorting the ration array
        double ratio[][] = new double[weight.length][2];

        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;    //Storing indices
            ratio[i][1] = value[i] / (double)weight[i];     //Storing ratio
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));    //Sorting the array in ASCENDING order

        int capacity = W;
        int maxVal = 0;

        for (int i = ratio.length - 1; i >= 0; i--) {
            int index = (int)ratio[i][0];
            if (capacity >= weight[index]) {     //The space in the bag is more than the weight of the item. So, we include the whole of it. 
                //Updating the value of capacity and updating the value of maxVal variable
                maxVal = maxVal + value[index];
                capacity = capacity - weight[index];
            }

            else {     //include fractional items
                maxVal += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }

        return maxVal;
    }
    public static void main(String[] args) {
        int weight[] = {2,3,5,};
        int value[] = {10,5,15};
        int W = 8;

        System.out.println(maxValue(weight, value, W));
    }
}
