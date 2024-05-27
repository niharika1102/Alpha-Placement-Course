import java.util.*;

public class MinimumAbsoluteDifferencePair {
    public static int minDiff(int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);

        int diff = 0;

        for (int i = 0; i < A.length; i++) {
            diff = diff + Math.abs(A[i] - B[i]);
        }

        return diff;
    }
    public static void main(String[] args) {
        int A[] = {4,1,8,7};
        int B[] = {2,3,6,5};

        System.out.println(minDiff(A, B));
    }
}
