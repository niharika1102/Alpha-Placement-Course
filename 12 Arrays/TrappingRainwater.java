import java.util.*;

public class TrappingRainwater {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int height[] = {4,2,0,6,3,2,5};

        int width = 1;

        int heightSize = height.length;

        //To calculate leftmax
        int leftMax[] = new int[heightSize];
        leftMax[0] = height[0];

        for (int i = 1; i < heightSize; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        //To calculate rightMax
        int rightMax[] = new int[heightSize];
        rightMax[heightSize - 1] = height[heightSize - 1];

        for (int i = heightSize - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        //Min out of leftmax and rightmax
        int finalMin[] = new int[heightSize];

        for (int i = 0; i < heightSize; i++) {
            finalMin[i] = Math.min(rightMax[i], leftMax[i]);
        }

        //Final computation
        int totalTrapped = 0;

        for (int i = 0; i < heightSize; i++) {
            int indiTrapped = (finalMin[i] - height[i]) * width;

            totalTrapped = totalTrapped + indiTrapped;
        }

        System.out.println(totalTrapped);
        
        input.close();
    }
}
