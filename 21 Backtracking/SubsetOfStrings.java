import java.util.*;

public class SubsetOfStrings {

    public static void findSubset(String str, String ans, int i) {     //i is the index of the character which we are processing
        //base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.print("NULL_SET");
            }
            System.out.print(ans + " ");
            return;
        }

        //Recursion
        //Yes
        findSubset(str, ans + str.charAt(i), i + 1);
        //No
        findSubset(str, ans, i + 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String str = "abc";
        String ans = "";
        findSubset(str, ans, 0);
        
        input.close();
    }
}
