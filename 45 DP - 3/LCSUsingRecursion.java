import java.util.*;

public class LCSUsingRecursion {
    public static int lcsLength(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {     //Either of the two strings is empty
            return 0;
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return lcsLength(str1, str2, n - 1, m - 1) + 1;       //Same character, so decrease length of both strings by 1 each
        }

        //Characters are different, so, we have a choice to decrease the length of either of the strings at a time.
        int ans1 = lcsLength(str1, str2, n - 1, m);
        int ans2 = lcsLength(str1, str2, n, m - 1);
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";

        System.out.println(lcsLength(str1, str2, str1.length(), str2.length()));
    }
}
