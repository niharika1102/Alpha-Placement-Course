import java.util.*;

public class ContainerWithMostWater {
    public static int maxWaterOptimized(int heightArr[]) {
        int length = heightArr.length;
        int res = 0;

        //initilaze two pointers, left and right
        int left = 0;
        int right = length - 1;

        while (left < right) {
            int height = Math.min(heightArr[left], heightArr[right]);    //find min height out of left and right index elements
            int width = right - left;    //find width

            int area = height * width;      
            res = Math.max(res, area);
            if (heightArr[left] < heightArr[right]) {     //if left ele < right ele, move forward to find greater left ele
                left++;
            }
            else {     //if right ele < left ele, move backward to find greater right ele
                right--;
            }
        }
        return res;
    }

    public static int maxWaterBrute(int heightsArr[]) {
        int length = heightsArr.length;

        ArrayList<Integer> water = new ArrayList<>();
        int res = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int height = Math.min(heightsArr[i], heightsArr[j]);
                int width = j - i;

                int area = height * width;
                water.add(area);
            }
        }

        res = water.get(0);
        for (int i = 1; i < water.size(); i++) {
            if (water.get(i) > res) {
                res = water.get(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int heightsArr[] = {1,8,6,2,5,4,8,3,7};

        // int res = maxWaterBrute(heightsArr);
        int res = maxWaterOptimized(heightsArr);
        System.out.println(res);
        
        input.close();
    }
}
