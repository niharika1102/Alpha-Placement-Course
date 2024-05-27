import java.util.*;

public class MaxAreaInHistogram {
    public static int maxArea(int heights[]) {
        int highestArea = 0;
        int nextSmallerLeft[] = new int[heights.length];
        int nextSmallerRight[] = new int[heights.length];

        //Next smaller right
        Stack<Integer> st = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nextSmallerRight[i] = heights.length;
            }
            else {
                nextSmallerRight[i] = st.peek();
            }
            st.push(i);
        }

        //Next smaller left
        st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nextSmallerLeft[i] = -1;
            }
            else {
                nextSmallerLeft[i] = st.peek();
            }
            st.push(i);
        }

        //Area
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;

            int area = height * width;
            highestArea = Math.max(highestArea, area);
        }

        return highestArea;
    }
    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};

        System.out.println(maxArea(heights));
    }
}
