import java.util.*;

public class ActivitySelection {
    public static ArrayList<Integer> selectActivity(int start[], int end[]) {
        int count = 0;

        //In case the activities are not sorted, we form a 2d array to sort them according to their end times
        int activites[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activites[i][0] = i;    //Index of activity
            activites[i][1] = start[i];    //Start time of activity
            activites[i][2] = end[i];     //End time of activity
        }

        //To sort the 2d array
        Arrays.sort(activites, Comparator.comparingDouble(o -> o[2]));      //A lamba function to tell java based on which column sorting has to be done

        ArrayList<Integer> al = new ArrayList<>();    //To store activites performed
        count = 1;     //Selecting A0

        al.add(activites[0][0]);     //Index of first activity is stored
        int lastEnd = activites[0][2];      //Ending time of the last chosen activity. By default, it is the end of A0.

        for (int i = 1; i < end.length; i++) {
            if (activites[i][1] >= lastEnd) {       //Checking start time of next activity and comparing it with the end time of previous activity selected
                //select the activity
                count++;
                al.add(activites[i][0]);      //Index of selected activity is added
                lastEnd = activites[i][2];      //lastEnd is updated
            }
        }

        return al;
    }
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        System.out.println(selectActivity(start, end));
    }
}
